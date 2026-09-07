package pl.landas.systemrezerwacji.model;

public abstract class Osoba {
    private String imie;
    private String email;
    private String nazwisko;



    public Osoba(String imie, String nazwisko, String email) {
        setImie(imie);
        setEmail(email);
        setNazwisko(nazwisko);
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getEmail() {
        return email;
    }

    private void setImie(String imie) {
        if(imie == null || imie.isBlank()) {
            throw new IllegalArgumentException("Imię nie może być puste.");
        }
        this.imie = imie;
    }

    private void setEmail(String email) {
        if(email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email nie może być pusty.");
        }
        this.email = email;
    }

    private void setNazwisko(String nazwisko) {
        if(nazwisko == null || nazwisko.isBlank()) {
            this.nazwisko = "";
        } else {
            this.nazwisko = nazwisko;
        }
    }

    public void zmienDane(String noweImie, String noweNazwisko, String nowyEmail) {
        setImie(noweImie);
        setNazwisko(noweNazwisko);
        setEmail(nowyEmail);
    }
}
