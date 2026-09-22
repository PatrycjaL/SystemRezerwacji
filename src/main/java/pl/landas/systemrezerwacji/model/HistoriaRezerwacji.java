package pl.landas.systemrezerwacji.model;

import java.time.LocalDateTime;

public class HistoriaRezerwacji {
    private LocalDateTime dataZmiany;
    private StatusRezerwacji status;
    private Rezerwacja rezerwacja;

    public HistoriaRezerwacji(LocalDateTime dataZmiany, StatusRezerwacji status, Rezerwacja rezerwacja) {
        setDataZmiany(dataZmiany);
        setStatus(status);
        setRezerwacja(rezerwacja);
    }

    public LocalDateTime getDataZmiany() {
        return dataZmiany;
    }

    public StatusRezerwacji getStatus() {
        return status;
    }

    public Rezerwacja getRezerwacja() {
        return rezerwacja;
    }

    private void setStatus(StatusRezerwacji status) {
        if (status == null) {
            throw new IllegalArgumentException("Status nie może być pusty.");
        }
        this.status = status;
    }

    private void setDataZmiany(LocalDateTime dataZmiany) {
        if (dataZmiany == null) {
            throw new IllegalArgumentException("Data zmiany nie może być pusta.");
        }
        this.dataZmiany = dataZmiany;
    }

    private void setRezerwacja(Rezerwacja rezerwacja) {
        if (rezerwacja == null) {
            throw new IllegalArgumentException("Rezerwacja nie może być pusta.");
        }
        this.rezerwacja = rezerwacja;
    }

}
