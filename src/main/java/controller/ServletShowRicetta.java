package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletShowRicetta", value = "/ServletShowRicetta")
public class ServletShowRicetta extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/ricetta.jsp";

        Integer idRicetta = Integer.parseInt(request.getParameter("idRicetta"));

        Ricetta ricetta = new Ricetta();
        var serviceRicetta = new RicettaDAOImpl();
        var serviceIngredientiQuant = new IngredienteItemsDAOImpl();
        var serviceIngrediente = new IngredienteDAOImpl();
        var serviceCommenti = new CommentoDAOImpl();

        ricetta = serviceRicetta.doRetrieveRicettaByID(idRicetta);

        Utente utente = ricetta.getUtente();

        request.setAttribute("ricetta", ricetta);
        request.setAttribute("utente", utente);

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

        HttpSession session = request.getSession(true);

        Utente loggedUtente = (Utente) session.getAttribute("loggedUtente");

        if(loggedUtente == null) {

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
        else{

            boolean isPreferred = false;

            boolean esito = serviceRicetta.isPreferred(loggedUtente, ricetta);

            if(esito == true){
                isPreferred = true;
            }

            request.setAttribute("isPreferred", isPreferred);

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }
    }
}
