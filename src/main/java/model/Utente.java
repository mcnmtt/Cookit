package model;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Utente {

    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String dataNascita;
    private String foto; //100px x 100px
    private int ruolo; // - 0 utente registrato - 2 creator - 3 amministratore
    private Lista lista;
    private int status; //0 non bannato - 1 bannato
    private ArrayList<Ricetta> listaRicette;
    private ArrayList<Commento> listaCommenti;
    private ArrayList<Ordine> listaOrdini;
    private ArrayList<Salvare> listaPreferite;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes(StandardCharsets.UTF_8));
            this.password = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void setPasswordHash(String password){
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita.toString();
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(int ruolo) {
        this.ruolo = ruolo;
    }

    public Lista getLista() {
        return lista;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Commento> getListaCommenti() {
        return listaCommenti;
    }

    public void setListaCommenti(ArrayList<Commento> listaCommenti) {
        this.listaCommenti = listaCommenti;
    }

    public ArrayList<Ordine> getListaOrdini() {
        return listaOrdini;
    }

    public void setListaOrdini(ArrayList<Ordine> listaOrdini) {
        this.listaOrdini = listaOrdini;
    }

    public ArrayList<Ricetta> getListaRicette() {
        return listaRicette;
    }

    public void setListaRicette(ArrayList<Ricetta> listaRicette) {
        this.listaRicette = listaRicette;
    }

    public void setListaPreferite(ArrayList<Salvare> listaPreferite) {
        this.listaPreferite = listaPreferite;
    }

    public ArrayList<Salvare> getListaPreferite() {
        return listaPreferite;
    }
}
