package controller;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.util.List;

@WebServlet(name = "InitServlet", value = "/InitServlet", loadOnStartup = 0)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        var serviceCategoria = new CategoriaDAOImpl();
        List<Categoria> listaCategorie=serviceCategoria.doRetrieveAllCategoria();

        var serviceEtnia= new EtniaDAOImpl();
        List <Etnia> listaEtnie=serviceEtnia.doRetrieveAllEtnia();

        getServletContext().setAttribute("categorie", listaCategorie);
        getServletContext().setAttribute( "etnie", listaEtnie );
        super.init();
    }
}
