package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtenteDAOImpl implements UtenteDAO {

    public void addUtente(Utente utente) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO utente (email, password, nome, cognome, dataNascita, foto, ruolo, lista, status) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, utente.getEmail());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getNome());
            ps.setString(4, utente.getCognome());
            ps.setString(5, utente.getDataNascita());
            ps.setString(6, utente.getFoto());
            ps.setInt(7, utente.getRuolo());
            ps.setInt(8, utente.getLista().getID());
            ps.setInt(9, utente.getStatus());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUtente(Utente utente) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM utente WHERE email=?");
            ps.setString(1, utente.getEmail());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Utente> doRetrieveAllUtente() {

        ArrayList<Utente> listaUtenti = new ArrayList<>();

        Statement statement;

        ResultSet resultSet;

        Utente utente;

        try (Connection con = ConnPool.getConnection()) {

            statement = con.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM utente WHERE 1=1");

            while (resultSet.next()) {

                utente = new Utente();

                utente.setEmail(resultSet.getString(1));
                utente.setPassword(resultSet.getString(2));
                utente.setNome(resultSet.getString(3));
                utente.setCognome(resultSet.getString(4));
                utente.setDataNascita(resultSet.getString(5));
                utente.setFoto(resultSet.getString(6));
                utente.setRuolo(resultSet.getInt(7));
                Lista lista = new Lista();
                lista.setID(resultSet.getInt(8));
                utente.setLista(lista);
                utente.setStatus(resultSet.getInt(9));

                listaUtenti.add(utente);
            }
            return listaUtenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Utente> doRetrieveUtenteByRuolo(int ruolo) {

        List<Utente> listaUtenti = new ArrayList<>();

        ResultSet resultSet;
        Utente utente;

        try (Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE ruolo = ?");

            ps.setInt(1, ruolo);
            resultSet=ps.executeQuery();
            while (resultSet.next()) {

                utente = new Utente();

                utente.setEmail(resultSet.getString(1));
                utente.setPassword(resultSet.getString(2));
                utente.setNome(resultSet.getString(3));
                utente.setCognome(resultSet.getString(4));
                utente.setDataNascita(resultSet.getString(5));
                utente.setFoto(resultSet.getString(6));
                utente.setRuolo(resultSet.getInt(7));
                Lista lista = new Lista();
                lista.setID(resultSet.getInt(8));
                utente.setLista(lista);
                utente.setStatus(resultSet.getInt(9));

                listaUtenti.add(utente);
            }
            return listaUtenti;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveUtenteByEmail(String email) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT email, password, nome, cognome, dataNascita, foto, ruolo, lista, status FROM utente WHERE email=?");
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                Utente utente = new Utente();

                utente.setEmail(rs.getString(1));
                utente.setPassword(rs.getString(2));
                utente.setNome(rs.getString(3));
                utente.setCognome(rs.getString(4));
                utente.setDataNascita(rs.getString(5));
                utente.setFoto(rs.getString(6));
                utente.setRuolo(rs.getInt(7));
                Lista lista = new Lista();
                lista.setID(rs.getInt(8));
                utente.setLista(lista);
                utente.setStatus(rs.getInt(9));
                return utente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Utente doRetrieveUtenteByEmailPassword(String email, String password) {
        try (Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("SELECT * FROM utente WHERE email = ? AND password = SHA1(?)");

            ps.setString(1, email);

            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Utente utente = new Utente();

                utente.setEmail(rs.getString(1));
                utente.setPasswordHash(rs.getString(2));
                utente.setNome(rs.getString(3));
                utente.setCognome(rs.getString(4));
                utente.setDataNascita(rs.getString(5));
                utente.setFoto(rs.getString(6));
                utente.setRuolo(rs.getInt(7));
                Lista lista = new Lista();
                lista.setID(rs.getInt(8));
                utente.setLista(lista);
                utente.setStatus(rs.getInt(9));
                return utente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Utente doRetrieveUtenteByLista(Lista lista) {

        try (Connection con = ConnPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "SELECT email, password, nome, cognome, dataNascita, foto, ruolo, lista, status FROM utente WHERE lista=?");
            ps.setInt(1, lista.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Utente utente = new Utente();
                utente.setEmail(rs.getString(1));
                utente.setPassword(rs.getString(2));
                utente.setNome(rs.getString(3));
                utente.setCognome(rs.getString(4));
                utente.setDataNascita(rs.getString(5));
                utente.setFoto(rs.getString(6));
                utente.setRuolo(rs.getInt(7));
                Lista list = new Lista();
                list.setID(rs.getInt(8));
                utente.setLista(list);
                utente.setStatus(rs.getInt(9));
                return utente;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdateUtente(Utente utente, String email) { //Primo parametro indica l'object che contiene l'update, il secondo parametro l'identificatore dell'object da updatare nel DB

        try (Connection con = ConnPool.getConnection()) {
            Statement statement = con.createStatement();

            String query = "UPDATE utente SET email='" + utente.getEmail() + "', password='" + utente.getPassword()
                    + "', nome='" + utente.getNome() + "', cognome='" + utente.getCognome() + "', " + "dataNascita='"
                    + utente.getDataNascita() + "', foto='" + utente.getFoto() + "', ruolo='" + utente.getRuolo()
                    + "', lista='" + utente.getLista().getID() + "', status='" + utente.getStatus() + "', WHERE email="
                    + email + ";";

            statement.executeUpdate( query );
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }

    public void doUpdateRuolo(Utente utente, int ruolo) throws SQLException {

        try (Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("UPDATE utente SET ruolo = ? WHERE email = ?");
            ps.setInt(1, ruolo);
            ps.setString(2, utente.getEmail());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doUpdateStatus(Utente utente, int status) throws SQLException {

        try (Connection con = ConnPool.getConnection()) {

            PreparedStatement ps = con.prepareStatement("UPDATE utente SET status = ? WHERE email = ?");
            ps.setInt(1, status);
            ps.setString(2, utente.getEmail());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

