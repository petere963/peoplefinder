package javasound.peoplefinder.exception;

public class ApplicationException extends RuntimeException {

    public ApplicationException(String msg, Throwable t) {
        super(msg, t);
    }

    public ApplicationException(String msg) {
        super(msg);
    }
}
