package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngredienteItemsDAOImpl implements IngredienteItemsDAO
    {
        @Override
        public IngredienteItems doRetrieveByID(int id) throws SQLException {

            try (Connection con = ConnPool.getConnection()) {

                PreparedStatement ps = con.prepareStatement("SELECT * FROM composta WHERE id=?");

                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    IngredienteItems composta = new IngredienteItems();

                    composta.setId(id);

                    var serviceRicetta = new RicettaDAOImpl();
                    Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID(rs.getInt(2));
                    composta.setRicetta(ricetta);

                    var serviceIngrediente = new IngredienteDAOImpl();
                    Ingrediente ingrediente = serviceIngrediente.doRetrieveByID(rs.getInt(3));
                    composta.setIngrediente(ingrediente);

                    composta.setQuantita(rs.getInt(4));

                    return composta;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public List<IngredienteItems> doRetrieveAllByRicetta(Ricetta ricetta) throws SQLException {

            List<IngredienteItems> listaComposta = new ArrayList<>();

            ResultSet resultSet;

            IngredienteItems composta;

            try (Connection con = ConnPool.getConnection()) {

                PreparedStatement ps = con.prepareStatement("SELECT * FROM composta WHERE ricetta = ?");

                ps.setInt(1, ricetta.getID());

                resultSet=ps.executeQuery();

                while (resultSet.next()) {

                    composta = new IngredienteItems();

                    composta.setId(resultSet.getInt(1));
                    composta.setRicetta(ricetta);

                    var serviceIngrediente = new IngredienteDAOImpl();
                    Ingrediente ingrediente = serviceIngrediente.doRetrieveByID(resultSet.getInt(3));
                    composta.setIngrediente(ingrediente);

                    composta.setQuantita(resultSet.getInt(4));

                    listaComposta.add(composta);
                }
                return listaComposta;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public IngredienteItems doRetrieveByIngredienteQuantita(Ingrediente ingrediente, int quantita){
            try (Connection con = ConnPool.getConnection()) {

                PreparedStatement ps = con.prepareStatement("SELECT * FROM composta WHERE ingrediente = ? AND quantita = ?");

                ps.setInt(1, ingrediente.getID());

                ps.setInt(2, quantita);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    IngredienteItems composta = new IngredienteItems();

                    composta.setId(rs.getInt(1));

                    var serviceRicetta = new RicettaDAOImpl();
                    Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID(rs.getInt(2));
                    composta.setRicetta(ricetta);

                    composta.setIngrediente(ingrediente);
                    composta.setQuantita(quantita);

                    return composta;
                }
                return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
