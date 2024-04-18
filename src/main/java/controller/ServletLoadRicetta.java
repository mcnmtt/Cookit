package controller;

import com.google.gson.Gson;
import model.Ricetta;
import model.RicettaDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLoadRicetta", value = "/ServletLoadRicetta")
public class ServletLoadRicetta extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idRicetta = request.getParameter("idRicetta");

        var serviceRicetta = new RicettaDAOImpl();
        Ricetta ricetta = serviceRicetta.doRetrieveRicettaByID(Integer.parseInt(idRicetta));

        Gson gson = new Gson();

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(ricetta).toString());
    }
}
