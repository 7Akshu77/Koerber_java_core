package Exception;

import java.awt.event.FocusEvent;

public class CustomerException extends RuntimeException {
    public CustomerException(String message, Throwable cause) {
        super(message, cause);
    }
}
