package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletToMakeOrdine", value = "/ServletToMakeOrdine")
public class ServletToMakeOrdine extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String address = "/WEB-INF/page/listaspesa.jsp";

    RequestDispatcher dispatcher= request.getRequestDispatcher(address);
    dispatcher.forward( request, response );

    }
}
