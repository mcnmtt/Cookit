package model;

import java.util.ArrayList;

public class Ingrediente {

    private int ID;
    private String nome;
    private ArrayList<Ricetta> listaRicette;
    private ArrayList<Ordine> listaOrdini;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setListaRicette(ArrayList<Ricetta> listaRicette) {
        this.listaRicette = listaRicette;
    }

    public ArrayList<Ricetta> getListaRicette() {
        return listaRicette;
    }

    public ArrayList<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public void setListaOrdini(ArrayList<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }
}
