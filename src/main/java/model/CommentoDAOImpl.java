package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentoDAOImpl implements CommentoDAO {

    @Override
    public void addCommento(Commento commento) {

        try(Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO commento (id, testo, voto, ricetta, utente) VALUE (?,?,?,?,?)");

            ps.setInt(1, commento.getID());
            ps.setString(2, commento.getTesto());
            ps.setInt(3, commento.getVoto());
            ps.setInt(4, commento.getRicetta().getID());
            ps.setString(5, commento.getUtente().getEmail());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException(("INSERT error."));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCommentoNullVoto(Commento commento) {

        try(Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO commento (id, testo, ricetta, utente) VALUE (?,?,?,?)");

            ps.setInt(1, commento.getID());
            ps.setString(2, commento.getTesto());
            ps.setInt(3, commento.getRicetta().getID());
            ps.setString(4, commento.getUtente().getEmail());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException(("INSERT error."));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCommento(Commento commento) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM commento WHERE id=?");
            ps.setInt(1, commento.getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doUpdateCommento(Commento commento, int id) { //Primo parametro indica l'object che contiene l'update, il secondo parametro l'identificatore dell'object da updatare nel DB

        try (Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE commento SET id='" + commento.getID() + "', testo='" + commento.getTesto() + "', voto='" + commento.getVoto() + "', ricetta='" + commento.getRicetta().getID() + "', utente='" + commento.getUtente().getEmail() + "', WHERE id=" + id + ";";
            statement.executeUpdate(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Commento> doRetrieveAllCommentoByUtente(Utente utente) {

        ArrayList<Commento> listaCommenti = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM commento WHERE utente=?");

            ps.setString(1, utente.getEmail());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Commento commento = new Commento();

                commento.setID(resultSet.getInt(1));
                commento.setTesto(resultSet.getString(2));
                commento.setVoto(resultSet.getInt(3));

                Ricetta ricetta = new Ricetta();
                ricetta.setID(resultSet.getInt(4));
                commento.setRicetta(ricetta);

                commento.setUtente(utente);

                listaCommenti.add(commento);
            }

            return listaCommenti;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Commento> doRetrieveAllCommentoByRicetta(Ricetta ricetta) {

        ArrayList<Commento> listaCommenti = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM commento WHERE ricetta=? ORDER BY id DESC");

            ps.setInt(1, ricetta.getID());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Commento commento = new Commento();

                commento.setID(resultSet.getInt(1));
                commento.setTesto(resultSet.getString(2));
                commento.setVoto(resultSet.getInt(3));
                commento.setRicetta(ricetta);

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(5));
                commento.setUtente(utente);

                listaCommenti.add(commento);
            }

            return listaCommenti;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Commento doRetrieveByID(int id) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM commento WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                var serviceRicetta = new RicettaDAOImpl();
                Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID( rs.getInt( 4 ) );

                var serviceUtente = new UtenteDAOImpl();
                Utente utente = serviceUtente.doRetrieveUtenteByEmail( rs.getString( 5 ) );

                Commento commento = new Commento();
                commento.setID( rs.getInt( 1 ) );
                commento.setTesto(rs.getString(2));
                commento.setVoto( rs.getInt( 3 ) );
                commento.setRicetta( ricetta );
                commento.setUtente( utente );


                return commento;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public Integer doAVGVoto(Ricetta ricetta) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT AVG(voto) FROM commento WHERE ricetta=?");
            ps.setInt(1, ricetta.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Integer media = rs.getInt(1);

                return media;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
