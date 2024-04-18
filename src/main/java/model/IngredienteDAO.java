package model;

import java.sql.SQLException;
import java.util.List;

public interface IngredienteDAO {
    void doSave(Ingrediente ingrediente) throws SQLException;
    boolean doDelete (Ingrediente ingrediente) throws SQLException;
    boolean doUpdate (Ingrediente ingrediente) throws SQLException;
    List<Ingrediente> doRetrieveAll () throws SQLException;
    Ingrediente doRetrieveByID (int id) throws SQLException;
    Ingrediente doRetrieveByName (String nome) throws SQLException;
}
