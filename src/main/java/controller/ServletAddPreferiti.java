package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletAddPreferiti", value = "/ServletAddPreferiti")
public class ServletAddPreferiti extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idRicetta = Integer.parseInt(request.getParameter("idRicetta"));

        HttpSession session = request.getSession();

        Utente loggedUtente = (Utente) session.getAttribute("loggedUtente");

        var serviceRicetta = new RicettaDAOImpl();
        Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID(idRicetta);

        ArrayList<Salvare> listaPreferite = new ArrayList<>();

        var serviceSalvare = new SalvareDAOImpl();
        try {
            serviceSalvare.addFavourite(ricetta, loggedUtente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            listaPreferite = (ArrayList<Salvare>) serviceSalvare.doRetrieveFavouritesByUtente(loggedUtente);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        loggedUtente.setListaPreferite(listaPreferite);

        String address = "ServletShowRicetta?idRicetta="+idRicetta;

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
