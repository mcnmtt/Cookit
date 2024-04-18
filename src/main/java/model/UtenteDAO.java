package model;

import java.sql.SQLException;
import java.util.List;

public interface UtenteDAO {

    void addUtente(Utente utente) throws  SQLException;

    void deleteUtente(Utente utente) throws  SQLException;

    List<Utente> doRetrieveAllUtente() throws  SQLException;

    List<Utente> doRetrieveUtenteByRuolo(int id) throws SQLException;

    Utente doRetrieveUtenteByEmail(String email) throws  SQLException;

    Utente doRetrieveUtenteByEmailPassword(String email, String password) throws  SQLException;

    Utente doRetrieveUtenteByLista(Lista lista) throws  SQLException;

    void doUpdateUtente(Utente utente, String email) throws  SQLException;

    void doUpdateRuolo(Utente utente, int ruolo) throws SQLException;

    void doUpdateStatus(Utente utente, int status) throws SQLException;
}

