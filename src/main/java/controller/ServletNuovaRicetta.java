package controller;

import model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;



@WebServlet(name = "ServletNuovaRicetta", value = "/ServletNuovaRicetta")
public class ServletNuovaRicetta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/profilo.jsp";

        Ricetta nuovaRicetta = new Ricetta();
        var serviceRicetta = new RicettaDAOImpl();

        String kcal,tempoPrep, tempoCott,dosi, titolo, foto, procedimento;

        kcal = request.getParameter("nKcal");
        tempoPrep =request.getParameter("nTempoPrep");
        tempoCott = request.getParameter("nTempoCott");
        dosi=request.getParameter("nDosi");
        titolo=request.getParameter("titolo");
        foto=request.getParameter("foto");
        procedimento=request.getParameter("procedimento");

        nuovaRicetta.setNome(titolo);
        nuovaRicetta.setFoto(foto);
        nuovaRicetta.setKcal(Integer.parseInt(kcal));
        nuovaRicetta.setTempoPrep(Integer.parseInt(tempoPrep));
        nuovaRicetta.setTempoCott(Integer.parseInt(tempoCott));
        nuovaRicetta.setDosi(Integer.parseInt(dosi));
        nuovaRicetta.setProc(procedimento);

        HttpSession session = request.getSession();
        Utente loggedUtente = (Utente)session.getAttribute( "loggedUtente" );
        nuovaRicetta.setUtente( loggedUtente );

        Categoria categoria = new Categoria();
        categoria.setNome(request.getParameter("categorie"));
        nuovaRicetta.setCategoria( categoria );

        Etnia etnia = new Etnia ();
        etnia.setNome(request.getParameter("etnie"));
        nuovaRicetta.setEtnia( etnia );

        nuovaRicetta.setVoto( 0 );

        serviceRicetta.addRicetta(nuovaRicetta);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
        }
    }

