package restaurant.model;

import restaurant.model.exceptions.InvalidOrderStateException;
import restaurant.model.exceptions.OrderNotFoundException;

import java.time.LocalDateTime;
import java.util.*;

public class Order {

    public enum Status { NEW, PREPARING, SERVED, PAID, CANCELLED }

    private final String id;
    private Status status;
    private final List<OrderItem> items;
    private final LocalDateTime createdAt;

    public Order() {
        this(UUID.randomUUID().toString(), new ArrayList<>());
    }

    public Order(String id, List<OrderItem> items) {
        this.id = id;
        this.items = new ArrayList<>(items);
        this.status = Status.NEW;
        this.createdAt = LocalDateTime.now();
    }

    public static Order withSingleItem(MenuItem item, int qty) {
        Order o = new Order();
        o.addItem(new OrderItem(item, qty));
        return o;
    }

    public void addItem(OrderItem item) {
        if (status != Status.NEW)
            throw new InvalidOrderStateException("Can only add items when order is NEW");
        items.add(item);
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public Money total() {
        Money t = new Money(0);
        for (OrderItem i : items) {
            t = t.add(i.lineTotal());
        }
        return t;
    }

    public void setStatus(Status s) { this.status = s; }
    public Status getStatus() { return status; }

    public OrderItem removeItemByMenuId(String id) throws OrderNotFoundException {
        for (OrderItem oi : items) {
            if (oi.getItem().id().equals(id)) {
                items.remove(oi);
                return oi;
            }
        }
        throw new OrderNotFoundException("Menu ID not found: " + id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order " + id + " (" + status + ")\n");
        for (OrderItem oi : items) sb.append(oi).append("\n");
        sb.append("Total: ").append(total());
        return sb.toString();
    }
}
