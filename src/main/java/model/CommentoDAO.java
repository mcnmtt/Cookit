package model;

import java.util.List;

public interface CommentoDAO {

    void addCommento(Commento commento);

    void addCommentoNullVoto(Commento commento);

    void deleteCommento(Commento commento);

    void doUpdateCommento(Commento commento, int id);

    List<Commento> doRetrieveAllCommentoByUtente(Utente utente);

    List<Commento> doRetrieveAllCommentoByRicetta(Ricetta ricetta);

    Commento doRetrieveByID(int id);

    Integer doAVGVoto(Ricetta ricetta);
}
