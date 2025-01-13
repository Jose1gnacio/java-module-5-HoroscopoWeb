package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Calendar;

import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;
import com.horoscopo.modelo.Usuario;

@WebServlet("/consultarSigno")
public class ConsultarHoroscopoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Leer el usuario logueado
        Usuario usuarioLogueado = (Usuario) session.getAttribute("usuarioLogueado");

        // Simplemente tomamos el .getAnimalHoroscopo() que se asignó en el registro
        String signoChino = usuarioLogueado.getAnimalHoroscopo();

        request.setAttribute("signoChino", signoChino);
        RequestDispatcher dispatcher = request.getRequestDispatcher("conocerSigno.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
