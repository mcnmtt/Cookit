package controller;

import model.Categoria;
import model.CategoriaDAOImpl;
import model.Etnia;
import model.EtniaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletGetCategorieAndEtnie", value = "/ServletGetCategorieAndEtnie")
public class ServletGetCategorieAndEtnie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/page/nuovaRicetta.jsp";

        ArrayList<Etnia> listaEtnie ;

        var serviceCategoria = new CategoriaDAOImpl();
        ArrayList<Categoria> listaCategorie = serviceCategoria.doRetrieveAllCategoria();

        request.setAttribute("categorie", listaCategorie);

        var serviceEtnia = new EtniaDAOImpl();
        listaEtnie= (ArrayList<Etnia>) serviceEtnia.doRetrieveAllEtnia();

        request.setAttribute("etnie", listaEtnie);

        RequestDispatcher dispatcher= request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }
}
