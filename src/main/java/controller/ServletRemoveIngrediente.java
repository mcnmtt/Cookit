package controller;

import model.IngredienteItems;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletRemoveIngrediente", value = "/ServletRemoveIngrediente")
public class ServletRemoveIngrediente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeIngrediente = request.getParameter("nomeIngrediente");

        HttpSession session = request.getSession();

        ArrayList<IngredienteItems> carrelloIngredienti = (ArrayList<IngredienteItems>) session.getAttribute("carrelloIngredienti");

        ArrayList<IngredienteItems> nuovoCarrelloIngredienti = carrelloIngredienti;

        for (IngredienteItems nameValue : carrelloIngredienti) {

            String nomeIngredienteNameValue = nameValue.getIngrediente().getNome();

            if(nomeIngredienteNameValue.equals(nomeIngrediente)) {
                nuovoCarrelloIngredienti.remove(nameValue);
                session.setAttribute("carrelloIngredienti", nuovoCarrelloIngredienti);
                return;
            }
        }
    }
}
