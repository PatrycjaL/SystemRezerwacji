package pl.landas.systemrezerwacji.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Firma {
    private String nazwaFirmy;
    private String adresFirmy;
    private String nip;
    private String numerTelefonuFirmy;
    private String emailFirmy;
    private boolean aktywna;
    private Wlasciciel wlasciciel;
    private List<Pracownik> listaPracownikow;
    private List<Usluga> listaUslug;

    public Firma(String nazwaFirmy, String adresFirmy, String nip, String numerTelefonuFirmy, String emailFirmy, Wlasciciel wlasciciel) {
        setNazwaFirmy(nazwaFirmy);
        setAdresFirmy(adresFirmy);
        setNip(nip);
        setNumerTelefonuFirmy(numerTelefonuFirmy);
        setEmailFirmy(emailFirmy);
        setWlasciciel(wlasciciel);
        this.aktywna = true;
        listaPracownikow = new ArrayList<>();
        listaUslug = new ArrayList<>();
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public String getAdresFirmy() {
        return adresFirmy;
    }

    public String getNip() {
        return nip;
    }

    public String getNumerTelefonuFirmy() {
        return numerTelefonuFirmy;
    }

    public String getEmailFirmy() {
        return emailFirmy;
    }

    public boolean isAktywna() {
        return aktywna;
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public List<Pracownik> getListaPracownikow() {
        return Collections.unmodifiableList(listaPracownikow);
    }

    public List<Usluga> getListaUslug() {
        return Collections.unmodifiableList(listaUslug);
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        if(nazwaFirmy == null || nazwaFirmy.isBlank()) {
            throw new IllegalArgumentException("Nazwa firmy nie może być pusta.");
        }
        this.nazwaFirmy = nazwaFirmy;
    }

    public void setAdresFirmy(String adresFirmy) {
        if(adresFirmy == null || adresFirmy.isBlank()) {
            throw new IllegalArgumentException("Adres firmy nie może być pusty.");
        }
        this.adresFirmy = adresFirmy;
    }

    public void setNip(String nip) {
        if(nip == null || nip.isBlank()) {
            throw new IllegalArgumentException("NIP nie może być pusty.");
        }
        this.nip = nip;
    }

    public void setNumerTelefonuFirmy(String numerTelefonuFirmy) {
        if(numerTelefonuFirmy == null || numerTelefonuFirmy.isBlank()) {
            throw new IllegalArgumentException("Numer telefonu firmy nie może być pusty.");
        }
        this.numerTelefonuFirmy = numerTelefonuFirmy;
    }

    public void setEmailFirmy(String emailFirmy) {
        if(emailFirmy == null || emailFirmy.isBlank()) {
            throw new IllegalArgumentException("Email firmy nie może być pusty.");
        }
        this.emailFirmy = emailFirmy;
    }

    public void aktywujFirme() {
        this.aktywna = true;
    }

    public void dezaktywujFirme() {
        this.aktywna = false;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        if(wlasciciel == null) {
            throw new IllegalArgumentException("Właściciel nie może być pusty.");
        }
        this.wlasciciel = wlasciciel;
    }

    public void dodajUsluge(Usluga usluga) {
        if (usluga == null) {
            throw new IllegalArgumentException("Usługa nie może być pusta.");
        }
        listaUslug.add(usluga);
    }

    public void dodajPracownika(Pracownik pracownik) {
        if (pracownik == null) {
            throw new IllegalArgumentException("Pracownik nie może być pusty.");
        }
        listaPracownikow.add(pracownik);
    }
}
