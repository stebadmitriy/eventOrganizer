package eventOrganizer.exception;

public class BadFileNameException extends Exception {
    public BadFileNameException() {
    }

    public BadFileNameException(String message) {
        super(message);
    }
}
