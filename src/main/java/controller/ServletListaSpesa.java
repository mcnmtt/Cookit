package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletListaSpesa", value = "/ServletListaSpesa")
public class ServletListaSpesa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String address = "/WEB-INF/page/listaspesa.jsp";

        HttpSession session = request.getSession();

        Utente utente = (Utente) session.getAttribute("loggedUtente");

        Salvare salvare = utente.getListaPreferite().get(0);

        Ricetta ricetta = salvare.getRicetta();

        request.setAttribute("ricetta", ricetta);

        var serviceIngredientiQuant = new IngredienteItemsDAOImpl();
        var serviceIngrediente = new IngredienteDAOImpl();

        ArrayList<IngredienteItems> listaIngredienti = null;
        try {
            listaIngredienti = (ArrayList<IngredienteItems>) serviceIngredientiQuant.doRetrieveAllByRicetta(ricetta);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ricetta.setListaIngredienti(listaIngredienti);


        for(int i = 0; i<listaIngredienti.size(); i++){
            try {
                Ingrediente ingrediente = serviceIngrediente.doRetrieveByID(listaIngredienti.get(i).getIngrediente().getID());
                listaIngredienti.get(i).setIngrediente(ingrediente);
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
        }

        request.setAttribute("listaIngredienti", ricetta.getListaIngredienti());

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
