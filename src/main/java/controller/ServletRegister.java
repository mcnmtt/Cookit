package controller;

import model.ListaDAOImpl;
import model.Utente;
import model.UtenteDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Utente utente = new Utente();
    var serviceUtente = new UtenteDAOImpl();

    var serviceLista = new ListaDAOImpl();
        try {
            serviceLista.addLista();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        String email, password, nome, cognome, foto, dataDiNascita;

    email = request.getParameter("email");
    password = request.getParameter("password");
    nome = request.getParameter("nome");
    cognome = request.getParameter("cognome");
    foto = request.getParameter("foto");
    dataDiNascita = request.getParameter("dataDiNascita");

    utente.setEmail(email);
    utente.setPassword(password);
    utente.setNome(nome);
    utente.setCognome(cognome);
    utente.setDataNascita(dataDiNascita);
    utente.setFoto(foto);
    utente.setRuolo(0);
    utente.setStatus(0);

    try {
        utente.setLista(serviceLista.getLastLista());
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    serviceUtente.addUtente(utente);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/page/success-register.jsp");
    dispatcher.forward(request, response);

    }
}


