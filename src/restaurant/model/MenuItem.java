package restaurant.model;

import java.util.Objects;

public record MenuItem(String id, String name, Category category, Money price) {

    public enum Category { STARTER, MAIN, DESSERT, DRINK }

    public MenuItem {
        Objects.requireNonNull(id);
        Objects.requireNonNull(name);
        Objects.requireNonNull(category);
        Objects.requireNonNull(price);

        if (price.value().doubleValue() < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - " + price;
    }
}

