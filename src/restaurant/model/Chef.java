package restaurant.model;

public final class Chef implements Role {
    private final String name;
    public Chef(String name) { this.name = name; }
    @Override public String name() { return name; }
    @Override public String roleName() { return "Chef"; }
}
