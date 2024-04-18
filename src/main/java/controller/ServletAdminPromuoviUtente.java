package controller;

import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAdminPromuoviUtente", value = "/ServletAdminPromuoviUtente")
public class ServletAdminPromuoviUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address ="ServletShowUserList";

        var serviceUtente = new UtenteDAOImpl();
        String email = request.getParameter( "utentiToPromote" );

        Utente utente = serviceUtente.doRetrieveUtenteByEmail( email );
        try {
            serviceUtente.doUpdateRuolo( utente, 2 );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher( address );
        dispatcher.forward( request, response );
    }
}
