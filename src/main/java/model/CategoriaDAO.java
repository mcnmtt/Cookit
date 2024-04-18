package model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CategoriaDAO {

    void addCategoria(Categoria categoria) throws  SQLException;

    void deleteCategoria(Categoria categoria) throws SQLException;

    void doUpdateCategoria(Categoria categoria, String nome) throws SQLException;

     ArrayList<Categoria> doRetrieveAllCategoria() throws SQLException;
}
