package controller;

import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCheckErrorLogin", value = "/ServletCheckErrorLogin")
public class ServletCheckErrorLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");

        if(email == ""){

            String text = "";

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(text);
        }
        if(email != "") {

            var serviceUtente = new UtenteDAOImpl();

            Utente utente = serviceUtente.doRetrieveUtenteByEmail(email);

            if (utente == null) {

                String isError = "true";

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(isError);
            } else {

                String isError = "false";

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(isError);
            }
        }
    }
}
