package model;

import java.sql.SQLException;
import java.util.List;

public interface OrdineDAO {

    void addOrdine(Ordine ordine) throws SQLException;

    List<Ordine> doRetrieveAllOrdineByUtente(Utente utente) throws SQLException;

   /* void deleteOrdine(Ordine ordine);

    List<Ordine> doRetrieveAllOrdine();

    Ordine doRetrieveById(int id);*/
}

