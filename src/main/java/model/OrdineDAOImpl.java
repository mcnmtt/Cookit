package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAOImpl implements OrdineDAO {

    public void addOrdine(Ordine ordine) {
        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO comporre (lista, composta, spedizione) VALUES (?,?,?)");

            ps.setInt(1, ordine.getLista().getID());
            ps.setInt(2, ordine.getComposta().getId());
            ps.setString(3, ordine.getSpedizione());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ordine> doRetrieveAllOrdineByUtente(Utente utente) {

        ArrayList<Ordine> listaOrdini = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM comporre WHERE lista = ?");

            ps.setInt(1, utente.getLista().getID());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Ordine ordine = new Ordine();

                ordine.setId(resultSet.getInt(1));
                ordine.setLista(utente.getLista());

                var serviceComposta = new IngredienteItemsDAOImpl();
                IngredienteItems composta = serviceComposta.doRetrieveByID(resultSet.getInt(3));
                ordine.setComposta(composta);

                ordine.setSpedizione(resultSet.getString(4));

                listaOrdini.add(ordine);
            }

            return listaOrdini;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
/*
    public void deleteOrdine(Ordine ordine) {
        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ordine WHERE num=?");
            ps.setInt(1, ordine.getNum());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ordine> doRetrieveAllOrdine() {

        ArrayList<Ordine> listaOrdini = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Ordine ordine;

        try(Connection con = ConnPool.getConnection()){

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM ordine WHERE 1=1");

            while(resultSet.next()) {

                ordine = new Ordine();

                ordine.setNum(resultSet.getInt(1));
                ordine.setData(resultSet.getString(2));
                ordine.setUtente(resultSet.getString(3));

                listaOrdini.add(ordine);
            }

            return listaOrdini;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Ordine> doRetrieveAllOrdineByUtente(Utente utente) {

        ArrayList<Ordine> listaOrdini = new ArrayList<>();

        ResultSet resultSet;

        Ordine ordine;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM ordine WHERE utente=?");

            ps.setString(1, utente.getEmail());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                ordine = new Ordine();

                ordine.setNum(resultSet.getInt(1));
                ordine.setData(resultSet.getString(2));
                ordine.setUtente(resultSet.getString(3));

                listaOrdini.add(ordine);
            }

            return listaOrdini;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Ordine doRetrieveById(int id) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT num, data, utente FROM ordine WHERE num=? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Ordine ordine = new Ordine();
                ordine.setNum(rs.getInt(1));
                ordine.setData(rs.getString(2));
                ordine.setUtente(rs.getString(3));
                return ordine;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
}

