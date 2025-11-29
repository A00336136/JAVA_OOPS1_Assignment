package restaurant.model;

public final class Waiter implements Role {
    private final String name;
    public Waiter(String name) { this.name = name; }
    @Override public String name() { return name; }
    @Override public String roleName() { return "Waiter"; }
}