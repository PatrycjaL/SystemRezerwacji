package pl.landas.systemrezerwacji.model;

public class Klient extends Osoba{
    private String numerTelefonu;

    public Klient(String imie, String nazwisko, String email, String numerTelefonu) {
        super(imie, nazwisko, email);
        setNumerTelefonu(numerTelefonu);
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    private void setNumerTelefonu(String numerTelefonu) {
        if(numerTelefonu == null || numerTelefonu.isBlank()) {
            throw new IllegalArgumentException("Numer telefonu nie może być pusty.");
        }
        this.numerTelefonu = numerTelefonu;
    }

    public void zmienDane(String imie, String nazwisko, String email, String numerTelefonu) {
        super.zmienDane(imie, nazwisko, email);
        setNumerTelefonu(numerTelefonu);
    }
}
