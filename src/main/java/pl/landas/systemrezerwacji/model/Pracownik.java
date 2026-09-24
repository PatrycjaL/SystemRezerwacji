package pl.landas.systemrezerwacji.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pracownik extends Osoba{
    private String hashHasla;
    private String stanowisko;
    private String numerTelefonu;
    private boolean aktywnosc;

    @ManyToOne
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;

    public Pracownik(String imie, String nazwisko, String email, String hashHasla, String stanowisko, String numerTelefonu, Firma firma) {
        super(imie, nazwisko, email);
        setHashHasla(hashHasla);
        setStanowisko(stanowisko);
        setNumerTelefonu(numerTelefonu);
        setFirma(firma);
        this.aktywnosc = true;
    }

    protected Pracownik() {
    }

    public String getHashHasla() {
        return hashHasla;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public boolean isAktywny() {
        return aktywnosc;
    }

    public Firma getFirma() {
        return firma;
    }

    private void setHashHasla(String hashHasla) {
        if(hashHasla == null || hashHasla.isBlank()) {
            throw new IllegalArgumentException("Hash hasła nie może być pusty.");
        }
        this.hashHasla = hashHasla;
    }

    private void setStanowisko(String stanowisko) {
        if(stanowisko == null || stanowisko.isBlank()) {
            throw new IllegalArgumentException("Stanowisko nie może być puste.");
        }
        this.stanowisko = stanowisko;
    }

    private void setNumerTelefonu(String numerTelefonu) {
        if(numerTelefonu == null || numerTelefonu.isBlank()) {
            throw new IllegalArgumentException("Numer telefonu nie może być pusty.");
        }
        this.numerTelefonu = numerTelefonu;
    }

    private void setFirma(Firma firma) {
        if(firma == null) {
            throw new IllegalArgumentException("Firma nie może być pusta.");
        }
        this.firma = firma;
    }

    public void aktywujPracownika() {
        this.aktywnosc = true;
    }

    public void dezaktywujPracownika() {
        this.aktywnosc = false;
    }

    public void zmienDanePracownika(String noweImie, String noweNazwisko, String nowyEmail, String noweStanowisko, String nowyNumerTelefonu) {
        super.zmienDane(noweImie, noweNazwisko, nowyEmail);
        setStanowisko(noweStanowisko);
        setNumerTelefonu(nowyNumerTelefonu);
    }

    public void zmienHaslo(String noweHaslo) {
        setHashHasla(noweHaslo);
    }
}