package controller;

import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletAdminDeleteCreators", value = "/ServletAdminDeleteCreators")
public class ServletAdminDeleteCreators extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address ="ServletShowUserList";

        var serviceUtente = new UtenteDAOImpl();
        String email = request.getParameter( "creators" ); // fetch email from the form.

        Utente utente = serviceUtente.doRetrieveUtenteByEmail(email); // fetch utente from the fetched email.
        try {
            serviceUtente.doUpdateStatus(utente, 1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward( request, response );
    }
}
