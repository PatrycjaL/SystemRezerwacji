package pl.landas.systemrezerwacji.dto;

public record WlascicielResponse(
        Long id,
        String imie,
        String nazwisko,
        String email
) {
}
