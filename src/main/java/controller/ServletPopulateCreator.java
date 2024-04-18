package controller;

import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletPopulateCreator", value = "/ServletPopulateCreator")
public class ServletPopulateCreator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String address = "/WEB-INF/page/creators.jsp";

        var serviceRicetta = new RicettaDAOImpl();

        List<Ricetta> listaRicetteCreators = serviceRicetta.doRetrieveRicettaByCreators();

        request.setAttribute("ricettaCreators", listaRicetteCreators);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }
}
