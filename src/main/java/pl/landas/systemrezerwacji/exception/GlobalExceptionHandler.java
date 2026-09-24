package pl.landas.systemrezerwacji.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> obsluzBladWalidacji(MethodArgumentNotValidException exception) {

        Map<String, String> bledy = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(blad -> {
            bledy.put(blad.getField(), blad.getDefaultMessage());
        });
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(bledy);
    }

    @ExceptionHandler(EmailJuzIstniejeException.class)
    public ResponseEntity<?> obsluzEmailJuzIstnieje(EmailJuzIstniejeException exception) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exception.getMessage());
    }
}
