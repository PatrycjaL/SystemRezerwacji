package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;

public class Powiadomienie {
    private LocalDateTime dataWyslania;
    private String tresc;
    private TypPowiadomienia typ;
    private StatusWysylkiPowiadomienia statusWysylki;
    private Rezerwacja rezerwacja;

    public Powiadomienie(String tresc, TypPowiadomienia typ, Rezerwacja rezerwacja) {
        setTresc(tresc);
        setTyp(typ);
        setRezerwacja(rezerwacja);
        this.statusWysylki = StatusWysylkiPowiadomienia.OCZEKUJACE;
    }

    public LocalDateTime getDataWyslania() {
        return dataWyslania;
    }

    public String getTresc() {
        return tresc;
    }

    public TypPowiadomienia getTyp() {
        return typ;
    }

    public StatusWysylkiPowiadomienia getStatusWysylki() {
        return statusWysylki;
    }

    public Rezerwacja getRezerwacja() {
        return rezerwacja;
    }

    private void setDataWyslania(LocalDateTime dataWyslania) {
        if(dataWyslania == null) {
            throw new IllegalArgumentException("Data wysłania nie może być pusta.");
        }
        this.dataWyslania = dataWyslania;
    }

    private void setTresc(String tresc) {
        if(tresc == null || tresc.isBlank()) {
            throw new IllegalArgumentException("Treść powiadomienia nie może być pusta.");
        }
        this.tresc = tresc;
    }

    private void setTyp(TypPowiadomienia typ) {
        if(typ == null) {
            throw new IllegalArgumentException("Typ powiadomienia nie może być pusty.");
        }
        this.typ = typ;
    }

    private void setRezerwacja(Rezerwacja rezerwacja) {
        if(rezerwacja == null) {
            throw new IllegalArgumentException("Rezerwacja nie może być pusta.");
        }
        this.rezerwacja = rezerwacja;
    }

    public void oznaczJakoWyslane(LocalDateTime dataWyslania) {
        if(StatusWysylkiPowiadomienia.WYSLANE == this.statusWysylki) {
            throw new IllegalStateException("Nie można oznaczyć powiadomienia jako wysłane, ponieważ zostało już wysłane.");
        }
        setDataWyslania(dataWyslania);
        this.statusWysylki = StatusWysylkiPowiadomienia.WYSLANE;
    }

    public void oznaczBlad() {
        if (StatusWysylkiPowiadomienia.WYSLANE == this.statusWysylki) {
            throw new IllegalStateException("Nie można oznaczyć powiadomienia jako błąd, ponieważ zostało już wysłane.");
        }
        this.statusWysylki = StatusWysylkiPowiadomienia.BLAD;
    }

}
