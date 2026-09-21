package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;

public class ZmianaDostepnosci {
    private Dostepnosc dostepnosc;
    private StatusZmianyDostepnosci status;
    private LocalDateTime proponowanyCzasRozpoczecia;
    private LocalDateTime proponowanyCzasZakonczenia;

    public ZmianaDostepnosci(Dostepnosc dostepnosc, LocalDateTime proponowanyCzasRozpoczecia, LocalDateTime proponowanyCzasZakonczenia) {
        if (dostepnosc == null) {
            throw new IllegalArgumentException("Dostępność nie może być pusta.");
        } else {
            this.dostepnosc = dostepnosc;
        }
        this.status = StatusZmianyDostepnosci.OCZEKUJACA;
        ustawProponowanyTermin(proponowanyCzasRozpoczecia, proponowanyCzasZakonczenia);
    }

    public Dostepnosc getDostepnosc() {
        return dostepnosc;
    }

    public StatusZmianyDostepnosci getStatus() {
        return status;
    }

    public LocalDateTime getProponowanyCzasRozpoczecia() {
        return proponowanyCzasRozpoczecia;
    }

    public LocalDateTime getProponowanyCzasZakonczenia() {
        return proponowanyCzasZakonczenia;
    }

    private void setStatus(StatusZmianyDostepnosci status) {
        if (status == null) {
            throw new IllegalArgumentException("Status zmiany dostępności nie może być pusty.");
        }
        this.status = status;
    }

    public void zatwierdzZmiane() {
        if (status != StatusZmianyDostepnosci.OCZEKUJACA && status != StatusZmianyDostepnosci.DO_KONSULTACJI) {
            throw new IllegalStateException("Zmiana dostępności może być zatwierdzona tylko wtedy, gdy jest w stanie OCZEKUJACA lub DO KONSULTACJI.");
        }
        dostepnosc.ustawDostepnosc(proponowanyCzasRozpoczecia, proponowanyCzasZakonczenia);
        setStatus(StatusZmianyDostepnosci.ZATWIERDZONA);
    }

    public void odrzucZmiane() {
        if (status != StatusZmianyDostepnosci.OCZEKUJACA && status != StatusZmianyDostepnosci.DO_KONSULTACJI) {
            throw new IllegalStateException("Zmiana dostępności może być odrzucona tylko wtedy, gdy jest w stanie OCZEKUJACA lub DO KONSULTACJI.");
        }
        setStatus(StatusZmianyDostepnosci.ODRZUCONA);
    }

    public void doKonsultacji() {
        if (status != StatusZmianyDostepnosci.OCZEKUJACA) {
            throw new IllegalStateException("Zmiana dostępności może być przekazana do konsultacji tylko wtedy, gdy jest w stanie OCZEKUJACA.");
        }
        setStatus(StatusZmianyDostepnosci.DO_KONSULTACJI);
    }

    private void ustawProponowanyTermin(LocalDateTime proponowanyCzasRozpoczecia, LocalDateTime proponowanyCzasZakonczenia) {
        if (proponowanyCzasRozpoczecia == null) {
            throw new IllegalArgumentException("Proponowany czas rozpoczęcia nie może być pusty.");
        }


        if (proponowanyCzasZakonczenia == null) {
            throw new IllegalArgumentException("Proponowany czas zakończenia nie może być pusty.");
        } else if (!proponowanyCzasZakonczenia.isAfter(proponowanyCzasRozpoczecia)) {
            throw new IllegalArgumentException("Niepoprawny proponowany czas zakończenia. Proponowany czas zakończenia musi być późniejszy niż proponowany czas rozpoczęcia.");
        }

        this.proponowanyCzasRozpoczecia = proponowanyCzasRozpoczecia;
        this.proponowanyCzasZakonczenia = proponowanyCzasZakonczenia;
    }

}
