package controller;

import model.Commento;
import model.CommentoDAOImpl;
import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAdminUtentiManagement", value = "/ServletAdminUtentiManagement")
public class ServletAdminUtentiManagement extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/adminPanel.jsp";
        var serviceUtente = new UtenteDAOImpl();
        Utente utente = new Utente();
        serviceUtente.deleteUtente( utente );
        serviceUtente.doUpdateUtente( utente, utente.getEmail() );

        var serviceCommento = new CommentoDAOImpl();
        Commento commento = new Commento();
        serviceCommento.deleteCommento( commento );

        RequestDispatcher dispatcher = request.getRequestDispatcher( address );
        dispatcher.forward( request, response );
    }
}
