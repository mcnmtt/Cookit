package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletGetUtente", value = "/ServletGetUtente")
public class ServletGetUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/profilo.jsp";

        Utente utente = new Utente();

        String email = request.getParameter("email");

        var serviceUtente = new UtenteDAOImpl();
        var serviceRicetta = new RicettaDAOImpl();

        utente = serviceUtente.doRetrieveUtenteByEmail(email);

        utente.setListaRicette((ArrayList<Ricetta>) serviceRicetta.doRetrieveAllRicettaByUtente(utente));

        request.setAttribute("utente", utente);

        utente.getListaRicette();

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
