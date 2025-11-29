package restaurant.model;

public sealed interface Role permits StaffManager, Chef, Waiter {
    String name();
    String roleName();
}
