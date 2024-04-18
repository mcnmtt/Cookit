package model;

import java.sql.SQLException;
import java.util.List;

public interface IngredienteItemsDAO {

    IngredienteItems doRetrieveByID (int id) throws SQLException;

    List<IngredienteItems> doRetrieveAllByRicetta (Ricetta ricetta) throws SQLException;

    IngredienteItems doRetrieveByIngredienteQuantita(Ingrediente ingrediente, int quantita) throws SQLException;
}
