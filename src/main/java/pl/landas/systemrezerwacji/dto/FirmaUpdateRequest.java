package pl.landas.systemrezerwacji.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.landas.systemrezerwacji.model.TrybDzialaniaFirmy;

public record FirmaUpdateRequest(
        @NotBlank(message = "Nazwa firmy nie może być pusta")
        String nazwaFirmy,

        @NotBlank(message = "Adres firmy nie może być pusty")
        String adresFirmy,

        @NotBlank(message = "NIP firmy nie może być pusty")
        String nipFirmy,

        @NotBlank(message = "Telefon firmy nie może być pusty")
        String telefonFirmy,

        @NotBlank(message = "Email firmy nie może być pusty")
        @Email(message = "Niepoprawny format adresu email")
        String emailFirmy,

        @NotNull(message = "Tryb działania firmy nie może być pusty")
        TrybDzialaniaFirmy trybDzialaniaFirmy
) {
}
