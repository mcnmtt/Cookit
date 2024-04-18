package model;

import java.util.ArrayList;

public class Lista {

    private int ID;
    private ArrayList<Ricetta> listaRicette;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public ArrayList<Ricetta> getListaRicette() {
        return listaRicette;
    }

    public void setListaRicette(ArrayList<Ricetta> listaRicette) {
        this.listaRicette = listaRicette;
    }
}
