package controller;

import model.Ordine;
import model.OrdineDAOImpl;
import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPopulateListaOrdine", value = "/ServletPopulateListaOrdine")
public class ServletPopulateListaOrdine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost( request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/page/userOrderList.jsp";

        Ordine ordine = new Ordine();
        var serviceOrdine = new OrdineDAOImpl();

        Utente utente = new Utente();
        var serviceUtente = new UtenteDAOImpl();
        ArrayList<Ordine>listaOrdini = new ArrayList<>();


        utente.getListaOrdini();

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward( request, response);
    }
}
