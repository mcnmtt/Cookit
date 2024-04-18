package model;

public class IngredienteItems {

    private int id;
    private Ricetta ricetta;
    private Ingrediente ingrediente;
    private int quantita;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente (Ingrediente ingrediente){this.ingrediente=ingrediente;}

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita){this.quantita=quantita;}

    public void setRicetta(Ricetta ricetta) {
        this.ricetta = ricetta;
    }

    public Ricetta getRicetta() {
        return ricetta;
    }
}
