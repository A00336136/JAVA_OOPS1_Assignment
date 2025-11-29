package restaurant.model;

public class OrderItem {

    private final MenuItem item;
    private int quantity;

    public OrderItem(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = Math.max(1, quantity);
    }

    public MenuItem getItem() { return item; }
    public int getQuantity() { return quantity; }

    public Money lineTotal() {
        return item.price().multiply(quantity);
    }

    @Override
    public String toString() {
        return quantity + " × " + item.name() + " = " + lineTotal();
    }
}
