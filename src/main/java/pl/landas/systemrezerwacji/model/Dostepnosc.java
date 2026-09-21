package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;

public class Dostepnosc {
    private LocalDateTime czasRozpoczecia;
    private LocalDateTime czasZakonczenia;
    private Pracownik pracownik;

    public Dostepnosc(LocalDateTime czasRozpoczecia, LocalDateTime czasZakonczenia, Pracownik pracownik) {
        ustawDostepnosc(czasRozpoczecia, czasZakonczenia);
        setPracownik(pracownik);
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

    public void ustawDostepnosc(LocalDateTime czasRozpoczecia, LocalDateTime czasZakonczenia) {
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

    private void setPracownik(Pracownik pracownik) {
        if (pracownik == null) {
            throw new IllegalArgumentException("Pracownik nie może być pusty.");
        }
        this.pracownik = pracownik;
    }
}
