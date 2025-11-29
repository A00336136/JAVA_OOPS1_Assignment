package restaurant.model;

public final class StaffManager implements Role {
    private final String name;
    public StaffManager(String name) { this.name = name; }
    @Override public String name() { return name; }
    @Override public String roleName() { return "Manager"; }
}