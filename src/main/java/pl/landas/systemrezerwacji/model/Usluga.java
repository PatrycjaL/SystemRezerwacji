package pl.landas.systemrezerwacji.model;

public class Usluga {
    private String nazwa;
    private double cena;
    private int czasTrwania;
    private boolean aktywna;

    public Usluga(String nazwaUslugi, double cenaUslugi, int czasTrwaniaUslugi) {
        setNazwa(nazwaUslugi);
        setCena(cenaUslugi);
        setCzasTrwania(czasTrwaniaUslugi);
        this.aktywna = true;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public boolean isAktywna() {
        return aktywna;
    }

    public void setNazwa(String nazwa) {
        if(nazwa == null || nazwa.isBlank()) {
            throw new IllegalArgumentException("Nazwa usługi nie może być pusta.");
        }
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        if (cena <= 0) {
            throw new IllegalArgumentException("Cena usługi musi być większa od zera.");
        }
        this.cena = cena;
    }

    public void setCzasTrwania(int czasTrwania) {
        if (czasTrwania <= 0) {
            throw new IllegalArgumentException("Czas trwania usługi musi być większy od zera.");
        }
        this.czasTrwania = czasTrwania;
    }

    public void aktywujUsluge() {
        this.aktywna = true;
    }

    public void dezaktywujUsluge() {
        this.aktywna = false;
    }
}
