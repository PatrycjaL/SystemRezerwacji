package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;

public class SlotCzasowy {
    private LocalDateTime czasRozpoczecia;
    private LocalDateTime czasZakonczenia;
    private Pracownik pracownik;

    public SlotCzasowy(LocalDateTime czasRozpoczecia, LocalDateTime czasZakonczenia, Pracownik pracownik) {
        ustawSlotCzasowy(czasRozpoczecia, czasZakonczenia);
        przypiszPracownika(pracownik);
    }

    public LocalDateTime getCzasRozpoczecia() {
        return czasRozpoczecia;
    }

    public LocalDateTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    private void ustawSlotCzasowy(LocalDateTime czasRozpoczecia, LocalDateTime czasZakonczenia) {
        if (czasRozpoczecia == null) {
            throw new IllegalArgumentException("Czas rozpoczęcia nie może być pusty.");
        } else if (czasZakonczenia == null) {
            throw new IllegalArgumentException("Czas zakończenia nie może być pusty.");
        } else if (!czasZakonczenia.isAfter(czasRozpoczecia)) {
            throw new IllegalArgumentException("Niepoprawny czas zakończenia. Czas zakończenia musi być późniejszy niż czas rozpoczęcia.");
        }
        this.czasRozpoczecia = czasRozpoczecia;
        this.czasZakonczenia = czasZakonczenia;
    }

    private void przypiszPracownika(Pracownik pracownik) {
        if (pracownik == null) {
            throw new IllegalArgumentException("Pracownik nie może być pusty.");
        }
        this.pracownik = pracownik;
    }
}
