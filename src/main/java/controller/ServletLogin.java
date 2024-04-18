package controller;

import model.Salvare;
import model.SalvareDAOImpl;
import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/login.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email, password;

        email = request.getParameter("email");
        password = request.getParameter("password");

        var serviceUtente = new UtenteDAOImpl();

        Utente utente = serviceUtente.doRetrieveUtenteByEmailPassword(email, password);

        if(utente == null){

            boolean errorLogin = true;

            request.setAttribute("errorLogin", errorLogin);

            String address = "/WEB-INF/page/login.jsp";

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }

        if(utente != null) {

            HttpSession session = request.getSession(true);

                if(utente.getStatus() == 1){

                    String address = "/WEB-INF/page/banned.jsp";

                    RequestDispatcher dispatcher = request.getRequestDispatcher(address);
                    dispatcher.forward(request, response);
                }

                if(utente.getStatus() != 1) {

                    var servicePreferite = new SalvareDAOImpl();

                    try {
                        ArrayList<Salvare> listaPreferite = (ArrayList<Salvare>) servicePreferite.doRetrieveFavouritesByUtente(utente);
                        utente.setListaPreferite(listaPreferite);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }

                    session.setAttribute("loggedUtente", utente);

                    boolean isLogged = true;

                    session.setAttribute("isLogged", isLogged);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("populateHome");
                    dispatcher.forward(request, response);
                }
        }
    }
}
