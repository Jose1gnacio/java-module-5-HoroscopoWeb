package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;
import com.horoscopo.modelo.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Usuario user = usuarioDAO.login(username, password);
        if(user != null) {
            // Login correcto
            HttpSession session = request.getSession();
            session.setAttribute("usuarioLogueado", user);
            // Redirige al menú principal
            response.sendRedirect("menu.jsp");
        } else {
            // Error en login
            request.setAttribute("mensaje", "Usuario o contraseña incorrectos");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    // Si deseas manejar GET (por si viene vació):
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
