package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;

@WebServlet("/eliminar")
public class EliminarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String usuario = request.getParameter("usuario");

        boolean eliminado = usuarioDAO.eliminar(usuario);
        if(eliminado) {
            request.setAttribute("mensaje", "Usuario eliminado exitosamente");
        } else {
            request.setAttribute("mensaje", "No se pudo eliminar al usuario");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("eliminarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
