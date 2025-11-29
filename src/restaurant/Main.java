package restaurant;

import restaurant.model.*;
import restaurant.model.MenuItem.Category;
import restaurant.model.Payment;
import restaurant.model.Payment.Card;
import restaurant.services.Billing;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Create Menu (use full package: restaurant.model.Menu)
        Menu menu = new Menu();

        MenuItem m1 = new MenuItem("m1", "Tomato Soup", Category.STARTER, new Money(3.50));
        MenuItem m2 = new MenuItem("m2", "Margherita Pizza", Category.MAIN, new Money(8.50));
        MenuItem m3 = new MenuItem("m3", "Tiramisu", Category.DESSERT, new Money(4.00));
        MenuItem m4 = new MenuItem("m4", "Coke", Category.DRINK, new Money(2.00));

        menu.addItems(m1, m2, m3, m4);

        // Create order
        Order order = Order.withSingleItem(m2, 2);
        order.addItem(new OrderItem(m4, 2));

        System.out.println("=== ORDER DETAILS ===");
        System.out.println(order);

        // Checked exception
        try {
            order.removeItemByMenuId("wrong-id");
        } catch (Exception e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        // Sorting menu using generics properly
        ArrayList<MenuItem> list = new ArrayList<>(menu.getItems());
        list.sort((a, b) -> a.price().value().compareTo(b.price().value()));
        list.forEach(System.out::println);

        // Payment demo
        Payment payment = new Card("4111222233334444", "Alice");
        Billing billing = Billing.simpleBilling();
        billing.pay(order, payment);

        // Switch expression
        System.out.println("=== ORDER STATUS MESSAGE ===");
        String msg = switch (order.getStatus()) {
            case NEW -> "Order created";
            case PREPARING -> "Being prepared";
            case SERVED -> "Served to customer";
            case PAID -> "Payment received!";
            case CANCELLED -> "Order cancelled";
        };
        System.out.println(msg);

        // Sealed Role demo
        Role r1 = new StaffManager("Bob");
        Role r2 = new Chef("Sofia");
        Role r3 = new Waiter("James");
        System.out.println(r1.name() + " - " + r1.roleName());
        System.out.println(r2.name() + " - " + r2.roleName());
        System.out.println(r3.name() + " - " + r3.roleName());

        // Java 22 Optional Demo
        Java22Demo.run(menu);
    }
}
