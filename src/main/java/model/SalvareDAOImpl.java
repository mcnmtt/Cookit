package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalvareDAOImpl implements SalvareDAO {
    @Override
    public void addFavourite(Ricetta ricetta, Utente utente) throws SQLException {

        try(Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("INSERT INTO salvare (ricetta,utente) VALUE (?,?)");

            ps.setInt(1, ricetta.getID());
            ps.setString(2, utente.getEmail());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException(("INSERT error."));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteFavourite(Ricetta ricetta, Utente utente) throws SQLException {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM salvare WHERE ricetta=? AND utente=?");
            ps.setInt(1, ricetta.getID());
            ps.setString(2, utente.getEmail() );
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Salvare> doRetrieveAllFavourites() throws SQLException {
            ResultSet resultSet;
            List<Salvare> listaPreferiti = new ArrayList<>();
            try (Connection con = ConnPool.getConnection()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM salvare WHERE 1=1;");
                resultSet = ps.executeQuery();

                while(resultSet.next()) {
                    Salvare salvare = new Salvare();
                    var serviceUtente = new UtenteDAOImpl();
                    var serviceRicetta = new RicettaDAOImpl();

                    salvare.setId( resultSet.getInt(1) );
                    Utente utente = serviceUtente.doRetrieveUtenteByEmail( resultSet.getString( 2 ));
                    salvare.setUtente( utente );
                    Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID( resultSet.getInt( 3 ) );
                    salvare.setRicetta( ricetta );
                    listaPreferiti.add(salvare);
                }
                return listaPreferiti;

            } catch (SQLException e) {
                throw new RuntimeException();
            }
        }

    @Override
    public List<Salvare> doRetrieveFavouritesByRicetta(Ricetta ricetta) throws SQLException {

        ArrayList<Salvare> listaFavourites = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM salvare WHERE ricetta=?");

            ps.setInt(1, ricetta.getID());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Salvare salvare = new Salvare();
                salvare.setId( resultSet.getInt( 1 ) );

                var serviceUtente = new UtenteDAOImpl();
                Utente utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString( 2 ));
                salvare.setUtente( utente );
                salvare.setRicetta( ricetta );
                listaFavourites.add(salvare);
            }

            return listaFavourites;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        }

    public List<Salvare> doRetrieveFavouritesByUtente(Utente utente) throws SQLException{
        ArrayList<Salvare> listaFavourites = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM salvare WHERE utente=?");

            ps.setString(1, utente.getEmail());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Salvare salvare = new Salvare();
                salvare.setId( resultSet.getInt( 1 ) );

                salvare.setUtente( utente );

                var serviceRicetta=new RicettaDAOImpl();
                Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID(resultSet.getInt( 3 ));
                salvare.setRicetta( ricetta );


                listaFavourites.add(salvare);
            }

            return listaFavourites;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
