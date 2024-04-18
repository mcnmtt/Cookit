package model;

public class Salvare {

    private int id;
    private Utente utente;
    private Ricetta ricetta;

    public int getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }

    public Ricetta getRicetta() {
        return ricetta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setRicetta(Ricetta ricetta) {
        this.ricetta = ricetta;
    }
}
