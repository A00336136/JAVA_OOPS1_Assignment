package restaurant.services;

import restaurant.model.*;

import java.util.Optional;

public interface Billing {

    Money calculateTotal(Order order);

    default boolean pay(Order order, Payment payment) {
        Money total = calculateTotal(order);
        Optional<String> result = PaymentProcessor.process(payment, total);

        System.out.println(result.orElse("Payment failed"));
        order.setStatus(Order.Status.PAID);

        return true;
    }

    private void logSuccess(String msg) {
        System.out.println("Billing Log: " + msg);
    }

    static Billing simpleBilling() {
        return (order) -> order.total();
    }
}
