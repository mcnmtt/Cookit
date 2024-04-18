package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtniaDAOImpl implements EtniaDAO {

    public List<Etnia> doRetrieveAllEtnia() {

        ArrayList<Etnia> listaEtnie = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Etnia etnia;

        try(Connection con = ConnPool.getConnection()){

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM etnia WHERE 1=1");

            while(resultSet.next()) {

                etnia = new Etnia();

                etnia.setNome(resultSet.getString(1));

                listaEtnie.add(etnia);
            }

            return listaEtnie;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void addEtnia(Etnia etnia) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO etnia (nome) VALUES(?)");
            ps.setString(1, etnia.getNome());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteEtnia(Etnia etnia) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM etnia WHERE nome=?");
            ps.setString(1, etnia.getNome());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Etnia doRetrieveByName(String name) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT nome FROM etnia WHERE nome=? ");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Etnia etnia = new Etnia();
                etnia.setNome(rs.getString(1));
                return etnia;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateEtnia(Etnia etnia, String name) {  //Primo parametro indica l'object che contiene l'update, il secondo parametro l'identificatore dell'object da updatare nel DB

        try(Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE etnia SET nome='"+etnia.getNome()+"' WHERE nome="+name+";";

            statement.executeUpdate(query);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


}