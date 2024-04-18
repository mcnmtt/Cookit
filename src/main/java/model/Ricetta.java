package model;

import java.util.ArrayList;

public class Ricetta {

    private int ID;
    private String nome;
    private String foto;
    private int kcal;
    private int tempoPrep;
    private int tempoCott;
    private int dosi;
    private String proc;
    private Utente utente;
    private Etnia etnia;
    private Categoria categoria;
    private int voto;
    private ArrayList<Lista> listaDiListe;
    private ArrayList<Commento> listaCommenti;
    private ArrayList<IngredienteItems> listaIngredienti;
    private ArrayList<Utente> listaPreferiti;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Etnia getEtnia() {
        return etnia;
    }

    public void setEtnia(Etnia etnia) {
        this.etnia = etnia;
    }

    public int getDosi() {
        return dosi;
    }

    public void setDosi(int dosi) {
        this.dosi = dosi;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getTempoCott() {
        return tempoCott;
    }

    public void setTempoCott(int tempoCott) {
        this.tempoCott = tempoCott;
    }

    public int getTempoPrep() {
        return tempoPrep;
    }

    public void setTempoPrep(int tempoPrep) {
        this.tempoPrep = tempoPrep;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public ArrayList<IngredienteItems> getListaIngredienti() {
        return listaIngredienti;
    }

    public void setListaIngredienti(ArrayList<IngredienteItems> listaIngredienti) {
        this.listaIngredienti = listaIngredienti;
    }

    public ArrayList<Commento> getListaCommenti() {
        return listaCommenti;
    }

    public void setListaCommenti(ArrayList<Commento> listaCommenti) {
        this.listaCommenti = listaCommenti;
    }

    public ArrayList<Lista> getListaDiListe() {
        return listaDiListe;
    }

    public void setListaDiListe(ArrayList<Lista> listaDiListe) {
        this.listaDiListe = listaDiListe;
    }

    public ArrayList<Utente> getListaPreferiti() {
        return listaPreferiti;
    }

    public void setListaPreferiti(ArrayList<Utente> listaPreferiti) {
        this.listaPreferiti = listaPreferiti;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public int getVoto() {
        return voto;
    }
}
