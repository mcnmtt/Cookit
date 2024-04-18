package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaDAOImpl implements ListaDAO
    {

    @Override
    public void doSave(ArrayList<Ingrediente> listaIngredienti) throws SQLException {

        String queryDoSave="INSERT INTO lista (id) values(?)";
        try(Connection con = ConnPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(queryDoSave)){
                ResultSet set = ps.executeQuery();
                Ingrediente ingrediente=new Ingrediente();
                while(set.next())
                    ingrediente.setID(set.getInt( "id"));
            }
        }
    }

    @Override
    public void doDelete(Ingrediente ingrediente) throws SQLException {

        String queryDoDelete="DELETE FROM lista WHERE id = ?";
        try (Connection con = ConnPool.getConnection ()){
            try(PreparedStatement ps= con.prepareStatement(queryDoDelete)){
                ps.setInt(1, ingrediente.getID());
            }
        }
    }

        @Override
        public void addLista() throws SQLException {

            try (Connection con = ConnPool.getConnection()) {
                PreparedStatement ps = con.prepareStatement("INSERT INTO lista SET id = NULL");
                if (ps.executeUpdate() != 1) {
                    throw new RuntimeException("INSERT error.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public Lista getLastLista() throws SQLException {

            try (Connection con = ConnPool.getConnection()) {
                PreparedStatement ps =
                        con.prepareStatement("SELECT * FROM lista WHERE id=(SELECT max(id) FROM lista)");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {

                    Lista lista = new Lista();

                    lista.setID(rs.getInt(1));

                    return lista;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        @Override
    public List<Ingrediente> doRetrieveAll() throws SQLException {

        String queryFetchAllIngredients= "SELECT * FROM lista";
        ArrayList<Ingrediente> listaIngredienti= new ArrayList<>();
        Ingrediente i= new Ingrediente();

        try(Connection con = ConnPool.getConnection()){
            try(PreparedStatement ps = con.prepareStatement(queryFetchAllIngredients)){
                ResultSet set = ps.executeQuery();
                while(set.next()){
                    i.setID(set.getInt(1));
                    listaIngredienti.add(i);
                }
            }
        }
        return listaIngredienti;
    }

    }
