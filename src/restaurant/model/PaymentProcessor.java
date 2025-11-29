package restaurant.model;

import java.util.Optional;

public class PaymentProcessor {

    public static Optional<String> process(Payment p, Money amount) {

        return switch (p) {

            case Payment.Cash c -> {
                if (c.amount().value().doubleValue() >= amount.value().doubleValue())
                    yield Optional.of("Cash payment accepted: " + c.amount());
                else
                    yield Optional.of("Insufficient cash");
            }

            case Payment.Card card ->
                    Optional.of("Card processed: ****" + card.cardNumber().substring(card.cardNumber().length() - 4));

            case Payment.DigitalWallet w ->
                    Optional.of("Digital Wallet used: " + w.provider() + " ID=" + w.id());
        };
    }
}
