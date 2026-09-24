package pl.landas.systemrezerwacji.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record WlascicielRequest(
    @NotBlank(message = "Imię właściciela nie może być puste.")
    String imie,

    @NotBlank(message = "Nazwisko właściciela nie może być puste.")
    String nazwisko,

    @NotBlank(message = "Email właściciela nie może być pusty.")
    @Email(message = "Niepoprawny format adresu email.")
    String email,

    @NotBlank(message = "Hasło właściciela nie może być puste.")
    @Size(min = 8, message = "Hasło musi mieć co najmniej 8 znaków.")
    String haslo
) {
}
