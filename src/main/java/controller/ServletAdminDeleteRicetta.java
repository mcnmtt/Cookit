package controller;

import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAdminDeleteRicetta", value = "/ServletAdminDeleteRicetta")
public class ServletAdminDeleteRicetta extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "ServletShowListaRicette";

    var serviceRicetta = new RicettaDAOImpl();
    String nome = request.getParameter("ricettaUtenti");
    Ricetta ricetta = serviceRicetta.doRetrieveRicettaIdByNome(nome);
    serviceRicetta.deleteRicetta(ricetta);

    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
    dispatcher.forward(request, response);

    }
}
