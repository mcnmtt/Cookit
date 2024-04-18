package controller;

import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPopulateUtenti", value = "/ServletPopulateUtenti")
public class ServletPopulateUtenti extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost (request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/utenti.jsp";

        var serviceRicetta = new RicettaDAOImpl();

        List<Ricetta> listaRicetteUtenti = serviceRicetta.doRetrieveRicettaForUtente();

        request.setAttribute("ricettaUtenti", listaRicetteUtenti);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
