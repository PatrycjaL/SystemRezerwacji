package pl.landas.systemrezerwacji.model;

import jakarta.persistence.*;


@Entity
public class Usluga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;
    private double cena;
    private int czasTrwania;
    private boolean aktywna;

    @ManyToOne
    @JoinColumn(name = "firma_id", nullable = false)
    private Firma firma;

    public Usluga(String nazwaUslugi, double cenaUslugi, int czasTrwaniaUslugi, Firma firma) {
        setNazwa(nazwaUslugi);
        setCena(cenaUslugi);
        setCzasTrwania(czasTrwaniaUslugi);
        setFirma(firma);
        this.aktywna = true;
    }

    protected Usluga() {
    }

    public Long getId() {
        return id;
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

    public Firma getFirma() {
        return firma;
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

    private void setFirma(Firma firma) {
        if (firma == null) {
            throw new IllegalArgumentException("Firma nie może być pusta.");
        }
        this.firma = firma;
    }
}
