package controller;

import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "populateHome", value = "/populateHome")
public class populateHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/homepage.jsp";

        var service = new RicettaDAOImpl();

        ArrayList<Ricetta> listaRicetteVotate = new ArrayList<>();

        listaRicetteVotate = (ArrayList<Ricetta>) service.doRetrieveAllRicettaOrderByVoto();

        request.setAttribute("ricette", listaRicetteVotate);

        ArrayList<Ricetta> listaRicetteRecenti = new ArrayList<>();

        listaRicetteRecenti = (ArrayList<Ricetta>) service.doRetrieveAllRicettaOrderByDate();

        request.setAttribute("ricettarecente", listaRicetteRecenti);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }
}
