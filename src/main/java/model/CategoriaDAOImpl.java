package model;

import java.sql.*;
import java.util.ArrayList;

public class CategoriaDAOImpl {

    public void addCategoria(Categoria categoria) {

        try(Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO categoria (nome) VALUE (?)");

            ps.setString(1, categoria.getNome());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException(("INSERT error."));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCategoria(Categoria categoria) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM categoria WHERE nome=?");
            ps.setString(1, categoria.getNome());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateCategoria(Categoria categoria, String nome) { //Primo parametro indica l'object che contiene l'update, il secondo parametro l'identificatore dell'object da updatare nel DB

        try (Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE categoria SET nome='" + categoria.getNome() + "', WHERE nome=" + nome + ";";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Categoria> doRetrieveAllCategoria() {
        ResultSet resultSet;
        ArrayList<Categoria> lista= new ArrayList<>();

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM categoria WHERE 1=1;");
            resultSet = ps.executeQuery();

            while(resultSet.next()) {
                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(1));

                lista.add(categoria);
            }

            return lista;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
