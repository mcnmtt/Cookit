package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAddCommento", value = "/ServletAddCommento")
public class ServletAddCommento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var serviceCommenti = new CommentoDAOImpl();

        String textarea = request.getParameter("textarea-commento");
        String email = request.getParameter("email");
        String star = request.getParameter("star");
        int idRicetta = Integer.parseInt(request.getParameter("ricettaID"));

        Commento commento = new Commento();

        var serviceUtente = new UtenteDAOImpl();
        Utente utente = serviceUtente.doRetrieveUtenteByEmail(email);

        commento.setUtente(utente);
        var serviceRicetta = new RicettaDAOImpl();
        Ricetta ricetta = new Ricetta();
        ricetta = serviceRicetta.doRetrieveRicettaByID(idRicetta);
        commento.setRicetta(ricetta);
        if(textarea == "") {
            commento.setTesto(null);
        }
        else {
            commento.setTesto(textarea);
        }
        if(star == null) {
            serviceCommenti.addCommentoNullVoto(commento);
        }
        else {
            commento.setVoto(Integer.parseInt(star));
            serviceCommenti.addCommento(commento);
        }

        String address = "ServletShowRicetta?idRicetta="+ricetta.getID();

        var serviceIngredientiQuant = new IngredienteItemsDAOImpl();
        var serviceIngrediente = new IngredienteDAOImpl();


        Utente utente1 = ricetta.getUtente();

        request.setAttribute("ricetta", ricetta);
        request.setAttribute("utente", utente1);

        ArrayList<IngredienteItems> listaIngredienti = null;
        try {
            listaIngredienti = (ArrayList<IngredienteItems>) serviceIngredientiQuant.doRetrieveAllByRicetta(ricetta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ricetta.setListaIngredienti(listaIngredienti);

        for(int i = 0; i<listaIngredienti.size(); i++){
            try {
                Ingrediente ingrediente = serviceIngrediente.doRetrieveByID(listaIngredienti.get(i).getIngrediente().getID());
                listaIngredienti.get(i).setIngrediente(ingrediente);
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        request.setAttribute("listaIngredienti", ricetta.getListaIngredienti());

        List<Commento> commenti = serviceCommenti.doRetrieveAllCommentoByRicetta(ricetta);

        request.setAttribute("listaCommenti", commenti);

        Integer nuovoRating = serviceCommenti.doAVGVoto(ricetta);

        serviceRicetta.doUpdateVotoRicetta(ricetta.getID(), nuovoRating);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
