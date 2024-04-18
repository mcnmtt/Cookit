package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ListaDAO {
    void doSave (ArrayList<Ingrediente> ingrediente) throws SQLException;
    void doDelete(Ingrediente ingrediente) throws SQLException;
    void addLista() throws SQLException;
    Lista getLastLista() throws SQLException;
    List<Ingrediente> doRetrieveAll () throws SQLException;

}
