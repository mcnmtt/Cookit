package controller;

import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ServletShowUserList", value = "/ServletShowUserList")
public class ServletShowUserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String address = "/WEB-INF/page/userManagement.jsp";

    var serviceUtente = new UtenteDAOImpl();

    List<Utente> listaUtenti = serviceUtente.doRetrieveUtenteByRuolo(0);

        for(Iterator<Utente> itr = listaUtenti.iterator(); itr.hasNext();){

            Utente utente = itr.next();

            if(utente.getStatus() == 1){

                itr.remove();
            }
        }

    List<Utente> listaUtentiCreators = serviceUtente.doRetrieveUtenteByRuolo(2);

        for(Iterator<Utente> itr = listaUtentiCreators.iterator(); itr.hasNext();){

            Utente utente = itr.next();

            if(utente.getStatus() == 1){

                itr.remove();
            }
        }

        List<Utente> listaUtentiBannati = serviceUtente.doRetrieveUtenteByRuolo(0);

        for(Iterator<Utente> itr = listaUtentiBannati.iterator(); itr.hasNext();){

            Utente utente = itr.next();

            if(utente.getStatus() != 1){

                itr.remove();
            }
        }

        List<Utente> listaUtentiCreatorsBannati = serviceUtente.doRetrieveUtenteByRuolo(2);

        for(Iterator<Utente> itr = listaUtentiCreatorsBannati.iterator(); itr.hasNext();){

            Utente utente = itr.next();

            if(utente.getStatus() != 1){

                itr.remove();
            }
        }

    request.setAttribute( "listaUtenti", listaUtenti );
        request.setAttribute( "listaUtentiBannati", listaUtentiBannati );
    request.setAttribute( "listaUtentiCreators", listaUtentiCreators );
        request.setAttribute( "listaUtentiCreatorsBannati", listaUtentiCreatorsBannati );

    RequestDispatcher dispatcher= request.getRequestDispatcher(address);
    dispatcher.forward( request, response );
    }
}
