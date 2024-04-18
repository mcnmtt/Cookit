package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletCheckRegisterName", value = "/ServletCheckRegisterName")
public class ServletCheckRegisterName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        boolean isValid = name.matches("[a-zA-Z]+");

        if(isValid == true){

            String valid = "true";

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(valid);
        }
        if(isValid == false){

            String valid = "false";

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(valid);
        }
    }
}
