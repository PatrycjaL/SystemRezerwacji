package pl.landas.systemrezerwacji.dto;

import pl.landas.systemrezerwacji.model.TrybDzialaniaFirmy;

public record FirmaResponse(
    Long id,
    String nazwaFirmy,
    String adresFirmy,
    String nip,
    String numerTelefonuFirmy,
    String emailFirmy,
    boolean aktywna,
    Long wlascicielId,
    TrybDzialaniaFirmy trybDzialaniaFirmy
) {
}
