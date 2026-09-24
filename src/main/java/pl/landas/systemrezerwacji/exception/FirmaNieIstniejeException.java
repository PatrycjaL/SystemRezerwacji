package pl.landas.systemrezerwacji.exception;

public class FirmaNieIstniejeException extends RuntimeException {
    public FirmaNieIstniejeException(String message) {
        super(message);
    }
}
