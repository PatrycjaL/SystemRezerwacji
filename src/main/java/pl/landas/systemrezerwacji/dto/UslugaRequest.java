package pl.landas.systemrezerwacji.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record UslugaRequest(
        @NotBlank(message = "Nazwa usługi nie może być pusta.")
        String nazwa,

        @Positive(message = "Cena usługi musi być większa od zera.")
        double cena,

        @Positive(message = "Czas trwania usługi musi być większy od zera.")
        int czasTrwania
) {
}
