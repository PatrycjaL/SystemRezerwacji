package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Rezerwacja {
    private StatusRezerwacji statusRezerwacji;
    private String notatkaDoRezerwacji;
    private LocalDateTime dataRozpoczecia;
    private LocalDateTime dataZakonczenia;
    private String tokenZarzadzania;
    private Klient klient;
    private Pracownik pracownik;
    private Usluga usluga;

    public Rezerwacja(String notatka, LocalDateTime dataRozpoczecia, Klient klient, Pracownik pracownik, Usluga usluga) {
        this.statusRezerwacji = StatusRezerwacji.UTWORZONA;
        setNotatkaDoRezerwacji(notatka);
        generujTokenZarzadzania();
        setKlient(klient);
        setPracownik(pracownik);
        setUsluga(usluga);
        setDataRozpoczecia(dataRozpoczecia);
        setDataZakonczenia();
    }

    public StatusRezerwacji getStatusRezerwacji() {
        return statusRezerwacji;
    }

    public String getNotatkaDoRezerwacji() {
        return notatkaDoRezerwacji;
    }

    public LocalDateTime getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public LocalDateTime getDataZakonczenia() {
        return dataZakonczenia;
    }

    public String getTokenZarzadzania() {
        return tokenZarzadzania;
    }

    public Klient getKlient() {
        return klient;
    }

    public Pracownik getPracownik() {
        return pracownik;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setNotatkaDoRezerwacji(String notatka) {
        if (notatka != null && !notatka.isBlank()) {
            this.notatkaDoRezerwacji = notatka;
        } else {
            this.notatkaDoRezerwacji = "";
        }
    }

    public void setDataRozpoczecia(LocalDateTime dataRozpoczecia) {
        if (dataRozpoczecia == null) {
            throw new IllegalArgumentException("Data rozpoczęcia rezerwacji nie może być pusta.");
        }
        this.dataRozpoczecia = dataRozpoczecia;
    }

    private void setDataZakonczenia() {
        this.dataZakonczenia = dataRozpoczecia.plusMinutes(usluga.getCzasTrwania());
    }

    private void generujTokenZarzadzania() {
        this.tokenZarzadzania = UUID.randomUUID().toString();
    }

    public void setKlient(Klient klient) {
        if (klient == null) {
            throw new IllegalArgumentException("Klient nie może być pusty.");
        }
        this.klient = klient;
    }

    public void setPracownik(Pracownik pracownik) {
        if (pracownik == null) {
            throw new IllegalArgumentException("Pracownik nie może być pusty.");
        }
        this.pracownik = pracownik;
    }

    public void setUsluga(Usluga usluga) {
        if (usluga == null) {
            throw new IllegalArgumentException("Usługa nie może być pusta.");
        }
        this.usluga = usluga;
    }

    public void potwierdzRezerwacje() {
        if (this.statusRezerwacji != StatusRezerwacji.UTWORZONA) {
            throw new IllegalStateException("Nie można potwierdzić rezerwacji w obecnym statusie - " + this.statusRezerwacji);
        }
        this.statusRezerwacji = StatusRezerwacji.POTWIERDZONA;
    }

    public void zrealizujRezerwacje() {
        if (this.statusRezerwacji != StatusRezerwacji.POTWIERDZONA) {
            throw new IllegalStateException("Nie można zrealizować rezerwacji w obecnym statusie - " + this.statusRezerwacji);
        }
        this.statusRezerwacji = StatusRezerwacji.ZREALIZOWANA;
    }

    public void anulujRezerwacje() {
        if (this.statusRezerwacji == StatusRezerwacji.ANULOWANA) {
            throw new IllegalStateException("Nie można anulować anulowanej rezerwacji.");
        } else if (this.statusRezerwacji == StatusRezerwacji.ZREALIZOWANA) {
            throw new IllegalStateException("Nie można anulować zrealizowanej rezerwacji.");
        }
        this.statusRezerwacji = StatusRezerwacji.ANULOWANA;
    }

    public void zmienTerminRezerwacji(LocalDateTime nowyTerminRozpoczecia) {
        if (this.statusRezerwacji == StatusRezerwacji.ANULOWANA) {
            throw new IllegalStateException("Nie można zmienić terminu anulowanej rezerwacji.");
        } else if (this.statusRezerwacji == StatusRezerwacji.ZREALIZOWANA) {
            throw new IllegalStateException("Nie można zmienić terminu zrealizowanej rezerwacji.");
        }
        setDataRozpoczecia(nowyTerminRozpoczecia);
        setDataZakonczenia();
    }

}
