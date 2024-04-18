package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletGenerateOrder", value = "/ServletGenerateOrder")
public class ServletGenerateOrder extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/page/ordineEseguito.jsp";

        HttpSession session = request.getSession();

        ArrayList<IngredienteItems> carrelloIngredienti = (ArrayList<IngredienteItems>) session.getAttribute("carrelloIngredienti");

        Utente utente = (Utente) session.getAttribute("loggedUtente");

        String stato, via, cap, citta, provincia;

        stato = (String) session.getAttribute("stato");

        via = (String) session.getAttribute("via");

        cap = (String) session.getAttribute("cap");

        citta = (String) session.getAttribute("citta");

        provincia = (String) session.getAttribute("provincia");

        var serviceOrdine = new OrdineDAOImpl();
        Ordine ordine = new Ordine();

        for(IngredienteItems composta : carrelloIngredienti){

            ordine.setLista(utente.getLista());
            ordine.setComposta(composta);
            ordine.setSpedizione(via+"/"+citta+"/"+cap+"/"+provincia+"/"+stato);

            serviceOrdine.addOrdine(ordine);
        }

        carrelloIngredienti = new ArrayList<>();

        session.setAttribute("carrelloIngredienti", carrelloIngredienti);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
