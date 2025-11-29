package restaurant.model;

import java.util.Objects;

public sealed interface Payment permits Payment.Cash, Payment.Card, Payment.DigitalWallet {

    record Cash(Money amount) implements Payment {
        public Cash { Objects.requireNonNull(amount); }
    }

    record Card(String cardNumber, String holder) implements Payment {
        public Card {
            Objects.requireNonNull(cardNumber);
            Objects.requireNonNull(holder);
        }
    }

    record DigitalWallet(String provider, String id) implements Payment {
        public DigitalWallet {
            Objects.requireNonNull(provider);
            Objects.requireNonNull(id);
        }
    }
}
