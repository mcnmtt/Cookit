package controller;

import model.Ordine;
import model.OrdineDAOImpl;
import model.Utente;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletPopulateOrder", value = "/ServletPopulateOrder")
public class ServletPopulateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/userOrderList.jsp";

        HttpSession session = request.getSession();

        Utente utente = (Utente) session.getAttribute("loggedUtente");

        var serviceOrdine = new OrdineDAOImpl();

        ArrayList<Ordine> listaOrdini = (ArrayList<Ordine>) serviceOrdine.doRetrieveAllOrdineByUtente(utente);

        request.setAttribute("listaOrdini", listaOrdini);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
