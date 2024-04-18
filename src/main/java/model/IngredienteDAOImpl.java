package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAOImpl implements IngredienteDAO
    {

    @Override
    public void doSave(Ingrediente ingrediente) throws SQLException {
        String queryDoSave="INSERT INTO ingrediente (id, nome) VALUES (?,?);";

        try(Connection con= ConnPool.getConnection ()){
            PreparedStatement ps = con.prepareStatement(queryDoSave);
            ps.setInt(1,ingrediente.getID());
            ps.setString(2, ingrediente.getNome());
        }
    }

    @Override
    public boolean doDelete(Ingrediente ingrediente) throws SQLException {
    String queryDoDelete ="DELETE FROM ingrediente WHERE id=?  LIMIT 1;";

    try(Connection con = ConnPool.getConnection()) {
        try(PreparedStatement ps = con.prepareStatement(queryDoDelete)) {
            ps.setInt(1, ingrediente.getID());
            ps.setString(2, ingrediente.getNome());

            int rows = ps.executeUpdate();
            return rows == 1;

            }
        }
    }

    @Override
    public boolean doUpdate(Ingrediente ingrediente) throws SQLException {
        String queryDoUpdate;
        queryDoUpdate = "UPDATE ingrediente SET id=?, nome=?" + ingrediente.getID() +
                "nome=?" + ingrediente.getNome() +
                "WHERE id=?";

        try (Connection con = ConnPool.getConnection()) {
            try (PreparedStatement ps = con.prepareStatement(queryDoUpdate)) {
                ps.setInt(1, ingrediente.getID());
                ps.setString(2, ingrediente.getNome());

                int rows=ps.executeUpdate();
                return rows==1;

            }
        }
    }

    @Override
    public List<Ingrediente> doRetrieveAll() throws SQLException {

        List<Ingrediente> listaIngredienti = new ArrayList<>();

        String queryRetrieveAll = "SELECT * FROM ingrediente WHERE 1=1 ;";

        try(Connection con = ConnPool.getConnection()){

            try(PreparedStatement ps= con.prepareStatement(queryRetrieveAll)){

                ResultSet rs = ps.executeQuery();

                while (rs.next()){

                    Ingrediente ingrediente= new Ingrediente();

                    ingrediente.setID(rs.getInt(1));
                    ingrediente.setNome(rs.getString(2));

                    listaIngredienti.add(ingrediente);
                }
                return listaIngredienti;
            }

        }
    }

        @Override
        public Ingrediente doRetrieveByID(int id) throws SQLException {

            try (Connection con = ConnPool.getConnection()) {

                PreparedStatement ps = con.prepareStatement("SELECT id, nome FROM ingrediente WHERE id=?");

                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    Ingrediente ingrediente = new Ingrediente();

                    ingrediente.setID(id);
                    ingrediente.setNome(rs.getString(2));

                    return ingrediente;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public Ingrediente doRetrieveByName(String nome) throws SQLException {

            try (Connection con = ConnPool.getConnection()) {
                PreparedStatement ps = con.prepareStatement(
                        "SELECT id, nome FROM ingrediente WHERE nome=?");
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Ingrediente ingrediente = new Ingrediente();

                    ingrediente.setID(rs.getInt(1));
                    ingrediente.setNome(rs.getString(2));
                    return ingrediente;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
