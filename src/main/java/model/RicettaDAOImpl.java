package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RicettaDAOImpl implements RicettaDAO {

    public void addRicetta(Ricetta ricetta) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ricetta (id, nome, foto, kcal, tempoPrep, tempoCott, dosi, procedimento, utente, etnia, categoria, voto) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, ricetta.getID());
            ps.setString(2, ricetta.getNome());
            ps.setString(3, ricetta.getFoto());
            ps.setInt(4, ricetta.getKcal());
            ps.setInt(5, ricetta.getTempoPrep());
            ps.setInt(6, ricetta.getTempoCott());
            ps.setInt(7, ricetta.getDosi());
            ps.setString(8, ricetta.getProc());
            ps.setString(9, ricetta.getUtente().getEmail());
            ps.setString(10, ricetta.getEtnia().getNome());
            ps.setString(11, ricetta.getCategoria().getNome());
            ps.setInt(12, ricetta.getVoto());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRicetta(Ricetta ricetta) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ricetta WHERE id=?");
            ps.setInt(1, ricetta.getID());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveAllRicetta() {

        ArrayList<Ricetta> listaRicette = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM ricetta WHERE 1=1");

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicette.add(ricetta);
            }
            return listaRicette;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateRicetta(Ricetta ricetta, int id) { //Primo parametro indica l'object che contiene l'update, il secondo parametro l'identificatore dell'object da updatare nel DB

        try (Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE ricetta SET id='" + ricetta.getID() + "', nome='" + ricetta.getNome()
                    + "', foto='" + ricetta.getFoto() + "', kcal='" + ricetta.getKcal() + "', " + "tempoPrep='"
                    + ricetta.getTempoPrep() + "', tempoCott='" + ricetta.getTempoCott() + "', dosi='" + ricetta.getDosi()
                    + "', procedimento='" + ricetta.getProc() + "', utente='" + ricetta.getUtente().getEmail()
                    + "', etnia='" + ricetta.getEtnia().getNome() + "', categoria='" + ricetta.getCategoria().getNome() + "', voto='" + ricetta.getVoto() + "', WHERE id="
                    + id + ";";

            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateVotoRicetta(int idRicetta, int nuovaVotazione){

        try (Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE ricetta SET voto = "+ nuovaVotazione + " WHERE id = " + idRicetta + ";";

            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ricetta doRetrieveRicettaByID(int id) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, foto, kcal, tempoPrep, tempoCott, dosi, procedimento, utente, etnia, categoria, voto FROM ricetta WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Ricetta ricetta = new Ricetta();

                ricetta.setID(rs.getInt(1));
                ricetta.setNome(rs.getString(2));
                ricetta.setFoto(rs.getString(3));
                ricetta.setKcal(rs.getInt(4));
                ricetta.setTempoPrep(rs.getInt(5));
                ricetta.setTempoCott(rs.getInt(6));
                ricetta.setDosi(rs.getInt(7));
                ricetta.setProc(rs.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(rs.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(rs.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(rs.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(rs.getInt(12));

                return ricetta;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveAllRicettaByUtente(Utente utente) {

        ArrayList<Ricetta> listaRicette = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM ricetta WHERE utente=?");

            ps.setString(1, utente.getEmail());

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Ricetta ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicette.add(ricetta);
            }

            return listaRicette;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveAllRicettaByLetters(String lett) {

        ArrayList<Ricetta> listaRicette = new ArrayList<>();

        ResultSet resultSet;

        try(Connection con = ConnPool.getConnection()){

            PreparedStatement ps = con.prepareStatement("SELECT * FROM ricetta WHERE nome LIKE '%"+lett+"%'");

            resultSet = ps.executeQuery();

            while(resultSet.next()) {

                Ricetta ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                var serviceUtente = new UtenteDAOImpl();
                Utente utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicette.add(ricetta);
            }

            return listaRicette;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveAllRicettaOrderByVoto() {

        ArrayList<Ricetta> listaRicette = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM ricetta WHERE 1=1 ORDER BY voto DESC");

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicette.add(ricetta);
            }
            return listaRicette;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveAllRicettaOrderByDate() {

        ArrayList<Ricetta> listaRicette = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM ricetta WHERE 1=1 ORDER BY ID DESC");

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicette.add(ricetta);
            }
            return listaRicette;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveRicettaByCreators() {

        List<Ricetta> listaRicettaCreators = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery(
                    "SELECT ricetta.* FROM ricetta, utente WHERE ricetta.utente = utente.email AND utente.ruolo =2 " );

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicettaCreators.add(ricetta);

            }
            return listaRicettaCreators;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isPreferred(Utente utente, Ricetta ricetta) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT ricetta FROM salvare WHERE utente=? AND ricetta=? ");
            ps.setString(1, utente.getEmail());
            ps.setInt(2, ricetta.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Ricetta ricetta1 = new Ricetta();
                ricetta1.setID(rs.getInt(1));

                if(ricetta1.getID() == ricetta.getID()) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveRicettaForUtente() {
        List<Ricetta> listaRicettaUtente = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery(
                    "SELECT ricetta.* FROM ricetta, utente WHERE ricetta.utente = utente.email AND utente.ruolo =0 " );

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicettaUtente.add(ricetta);

            }
            return listaRicettaUtente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ricetta> doRetrieveRicettaByAdmin() {

        List<Ricetta> listaRicettaCreators = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        Ricetta ricetta;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery(
                    "SELECT ricetta.* FROM ricetta, utente WHERE ricetta.utente = utente.email AND utente.ruolo =3 " );

            while (resultSet.next()) {

                ricetta = new Ricetta();

                ricetta.setID(resultSet.getInt(1));
                ricetta.setNome(resultSet.getString(2));
                ricetta.setFoto(resultSet.getString(3));
                ricetta.setKcal(resultSet.getInt(4));
                ricetta.setTempoPrep(resultSet.getInt(5));
                ricetta.setTempoCott(resultSet.getInt(6));
                ricetta.setDosi(resultSet.getInt(7));
                ricetta.setProc(resultSet.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(resultSet.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(resultSet.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(resultSet.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(resultSet.getInt(12));

                listaRicettaCreators.add(ricetta);

            }
            return listaRicettaCreators;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ricetta doRetrieveRicettaIdByNome(String nome){
        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT id, nome, foto, kcal, tempoPrep, tempoCott, dosi, procedimento, utente, etnia, categoria, voto FROM ricetta WHERE nome=?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Ricetta ricetta = new Ricetta();

                ricetta.setID(rs.getInt(1));
                ricetta.setNome(rs.getString(2));
                ricetta.setFoto(rs.getString(3));
                ricetta.setKcal(rs.getInt(4));
                ricetta.setTempoPrep(rs.getInt(5));
                ricetta.setTempoCott(rs.getInt(6));
                ricetta.setDosi(rs.getInt(7));
                ricetta.setProc(rs.getString(8));

                Utente utente = new Utente();
                var serviceUtente = new UtenteDAOImpl();
                utente = serviceUtente.doRetrieveUtenteByEmail(rs.getString(9));
                ricetta.setUtente(utente);

                Etnia etnia = new Etnia();
                etnia.setNome(rs.getString(10));
                ricetta.setEtnia(etnia);

                Categoria categoria = new Categoria();
                categoria.setNome(rs.getString(11));
                ricetta.setCategoria(categoria);

                ricetta.setVoto(rs.getInt(12));

                return ricetta;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
