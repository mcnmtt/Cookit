package model;

public class Ordine {

    private int id;
    private Lista lista;
    private IngredienteItems composta;
    private String spedizione;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLista(Lista lista) {
        this.lista = lista;
    }

    public Lista getLista() {
        return lista;
    }

    public IngredienteItems getComposta() {
        return composta;
    }

    public void setComposta(IngredienteItems composta) {
        this.composta = composta;
    }

    public String getSpedizione() {
        return spedizione;
    }

    public void setSpedizione(String spedizione) {
        this.spedizione = spedizione;
    }
}
