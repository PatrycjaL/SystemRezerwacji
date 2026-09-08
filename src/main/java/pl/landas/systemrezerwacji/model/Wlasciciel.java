package pl.landas.systemrezerwacji.model;

public class Wlasciciel extends Osoba{
    private String hashHasla;

    public Wlasciciel(String imie, String nazwisko, String email, String hashHasla) {
        super(imie, nazwisko, email);
        setHashHasla(hashHasla);
    }

    public String getHashHasla() {
        return hashHasla;
    }

    private void setHashHasla(String hashHasla) {
        if(hashHasla == null || hashHasla.isBlank()) {
            throw new IllegalArgumentException("Hash hasła nie może być pusty.");
        }
        this.hashHasla = hashHasla;
    }

    public void zmienHaslo(String noweHaslo) {
        setHashHasla(noweHaslo);
    }

    public void zmienDaneWlasciciela(String noweImie, String noweNazwisko, String nowyEmail) {
        super.zmienDane(noweImie, noweNazwisko, nowyEmail);
    }
}
