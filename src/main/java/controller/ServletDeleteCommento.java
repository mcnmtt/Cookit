package controller;

import model.Commento;
import model.CommentoDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDeleteCommento", value = "/ServletDeleteCommento")
public class ServletDeleteCommento extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("idCommento"));

        Commento commento;
        var serviceCommento = new CommentoDAOImpl();

        commento = serviceCommento.doRetrieveByID(ID);

        serviceCommento.deleteCommento( commento );

        String address ="ServletShowRicetta?idRicetta="+commento.getRicetta().getID();

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward( request, response );
    }
}
