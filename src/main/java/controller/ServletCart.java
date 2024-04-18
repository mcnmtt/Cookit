package controller;

import model.Ingrediente;
import model.IngredienteDAOImpl;
import model.IngredienteItems;
import model.IngredienteItemsDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletCart", value = "/ServletCart")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<IngredienteItems> carrelloIngredienti;

        var serviceIngrediente = new IngredienteDAOImpl();

        if(session.getAttribute("carrelloIngredienti") != null) {
            carrelloIngredienti = (ArrayList<IngredienteItems>) session.getAttribute("carrelloIngredienti");
        }
        else{
            carrelloIngredienti = new ArrayList<>();
        }

        try {
            ArrayList<Ingrediente> listaIngredienti = (ArrayList<Ingrediente>) serviceIngrediente.doRetrieveAll();

            for (Ingrediente ingrediente : listaIngredienti) {

                if (request.getParameter(ingrediente.getNome()) != null) {

                    int quantità = Integer.parseInt(request.getParameter(ingrediente.getNome()));

                    IngredienteItems nameValue = new IngredienteItems();

                    nameValue.setIngrediente(ingrediente);
                    nameValue.setQuantita(quantità);

                    var serviceComposta = new IngredienteItemsDAOImpl();
                    nameValue.setId(serviceComposta.doRetrieveByIngredienteQuantita(ingrediente, quantità).getId());

                    nameValue.setRicetta(serviceComposta.doRetrieveByIngredienteQuantita(ingrediente, quantità).getRicetta());


                    carrelloIngredienti.add(nameValue);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("carrelloIngredienti", carrelloIngredienti);

        String address = "/WEB-INF/page/cart.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);

        dispatcher.forward(request, response);

    }
}
