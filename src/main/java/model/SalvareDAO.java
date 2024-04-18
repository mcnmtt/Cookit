package model;

import java.sql.SQLException;
import java.util.List;

public interface SalvareDAO {
    void addFavourite(Ricetta ricetta, Utente utente) throws SQLException;
    void deleteFavourite(Ricetta ricetta, Utente utente) throws SQLException;
    List<Salvare> doRetrieveAllFavourites () throws SQLException;
    List<Salvare> doRetrieveFavouritesByRicetta (Ricetta ricetta) throws SQLException;
    List<Salvare> doRetrieveFavouritesByUtente (Utente utente) throws  SQLException;
}
