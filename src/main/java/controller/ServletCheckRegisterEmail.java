package controller;

import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCheckRegisterEmail", value = "/ServletCheckRegisterEmail")
public class ServletCheckRegisterEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        var serviceUtente = new UtenteDAOImpl();

        Utente utente = serviceUtente.doRetrieveUtenteByEmail(email);

        if(utente == null){

            String notExists = "true";

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(notExists);
        }
        if(utente != null){

            String notExists = "false";

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(notExists);
        }
    }
}
