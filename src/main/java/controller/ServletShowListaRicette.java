package controller;

import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletShowListaRicette", value = "/ServletShowListaRicette")
public class ServletShowListaRicette extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/recipesManagement.jsp";
        var serviceRicetta=new RicettaDAOImpl();
        List<Ricetta> listaRicetteUtenti = serviceRicetta.doRetrieveRicettaForUtente();
        List<Ricetta> listaRicetteCreators = serviceRicetta.doRetrieveRicettaByCreators();
        List<Ricetta> listaRicetteAdmin = serviceRicetta.doRetrieveRicettaByAdmin();

        request.setAttribute( "listaRicetteUtenti", listaRicetteUtenti );
        request.setAttribute( "listaRicetteCreators", listaRicetteCreators );
        request.setAttribute( "listaRicetteAdmin", listaRicetteAdmin );
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward( request, response );
    }
}
