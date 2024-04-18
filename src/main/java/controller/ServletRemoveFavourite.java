package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@WebServlet(name = "ServletRemoveFavourite", value = "/ServletRemoveFavourite")
public class ServletRemoveFavourite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost( request, response );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Salvare salvato = new Salvare();
    var serviceSalvato = new SalvareDAOImpl();
    var serviceRicetta = new RicettaDAOImpl();

    int idRicetta= Integer.parseInt( request.getParameter( "idRicetta" ) );
    Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID( idRicetta );

    HttpSession session = request.getSession();
    Utente loggedUtente = (Utente) session.getAttribute( "loggedUtente" );

        List <Salvare> listaPreferite = null;

        try {
            serviceSalvato.deleteFavourite(ricetta, loggedUtente);

            listaPreferite = loggedUtente.getListaPreferite();

            for(Iterator<Salvare> itr = listaPreferite.iterator(); itr.hasNext();){

                Salvare preferito = itr.next();

                if(preferito.getRicetta().getID() == ricetta.getID()){

                    itr.remove();
                }
            }

            loggedUtente.setListaPreferite((ArrayList<Salvare>) listaPreferite);

            session.setAttribute("loggedUtente", loggedUtente);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String address="ServletShowRicetta?iRicetta"+idRicetta;

        RequestDispatcher dispatcher= request.getRequestDispatcher( address );
        dispatcher.forward( request, response );
    }
}
