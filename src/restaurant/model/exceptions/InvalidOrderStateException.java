package restaurant.model.exceptions;

public class InvalidOrderStateException extends RuntimeException {
    public InvalidOrderStateException(String msg) {
        super(msg);
    }
}
