package restaurant.model;

import java.util.*;

public class Menu {

    private final List<MenuItem> items = new ArrayList<>();

    public void addItems(MenuItem... toAdd) {
        Collections.addAll(items, toAdd);
    }

    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public MenuItem findById(String id) {
        return items.stream().filter(i -> i.id().equals(id)).findFirst().orElse(null);
    }
}
