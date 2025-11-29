package restaurant.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {
    private final BigDecimal value;

    public Money(double amount) {
        this.value = BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal value() {
        return value;
    }

    public Money add(Money other) {
        return new Money(this.value.add(other.value).doubleValue());
    }

    public Money multiply(int qty) {
        return new Money(this.value.multiply(BigDecimal.valueOf(qty)).doubleValue());
    }

    @Override
    public String toString() {
        return "€" + value.toPlainString();
    }
}
