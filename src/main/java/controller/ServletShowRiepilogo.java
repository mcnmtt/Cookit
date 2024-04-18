package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletShowRiepilogo", value = "/ServletShowRiepilogo")
public class ServletShowRiepilogo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = "/WEB-INF/page/ordersummary.jsp";

        String stato, via, cap, citta, provincia;

        stato = request.getParameter("stato");
        via = request.getParameter("via");
        cap = request.getParameter("cap");
        citta = request.getParameter("citta");
        provincia = request.getParameter("provincia");

        HttpSession session = request.getSession();

        session.setAttribute("stato", stato);
        session.setAttribute("via", via);
        session.setAttribute("cap", cap);
        session.setAttribute("citta", citta);
        session.setAttribute("provincia", provincia);

        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
