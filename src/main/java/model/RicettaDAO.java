package model;

import java.util.List;

public interface RicettaDAO {

    void addRicetta(Ricetta ricetta);

    void deleteRicetta(Ricetta ricetta);

    List<Ricetta> doRetrieveAllRicetta();

    List<Ricetta> doRetrieveAllRicettaOrderByVoto();

    List<Ricetta> doRetrieveAllRicettaOrderByDate();

    void doUpdateRicetta(Ricetta ricetta, int id);

    void doUpdateVotoRicetta(int idRicetta, int nuovaVotazione);

    Ricetta doRetrieveRicettaByID(int id);

    List<Ricetta> doRetrieveAllRicettaByUtente(Utente utente);

    List<Ricetta> doRetrieveAllRicettaByLetters(String lett);

    boolean isPreferred(Utente utente, Ricetta ricetta);

    List<Ricetta> doRetrieveRicettaForUtente();

}
