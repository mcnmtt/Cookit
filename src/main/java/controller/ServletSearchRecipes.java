package controller;

import com.google.gson.Gson;
import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletSearchRecipes", value = "/ServletSearchRecipes")
public class ServletSearchRecipes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String ricerca = request.getParameter("search");

        var serviceRicetta = new RicettaDAOImpl();

        ArrayList<Ricetta> ricette = (ArrayList<Ricetta>) serviceRicetta.doRetrieveAllRicettaByLetters(ricerca);

        List<String> list = new ArrayList<>();

        for(Ricetta ricetta : ricette) {

            list.add(ricetta.getID()+". "+ricetta.getNome());
        }

        Gson json = new Gson();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJson(list));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
