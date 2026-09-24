package pl.landas.systemrezerwacji.exception;

public class EmailJuzIstniejeException extends RuntimeException {
    public EmailJuzIstniejeException(String message) {
        super(message);
    }
}
