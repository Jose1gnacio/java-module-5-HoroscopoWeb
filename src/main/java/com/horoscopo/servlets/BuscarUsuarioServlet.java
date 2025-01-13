package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;
import com.horoscopo.modelo.Usuario;

@WebServlet("/buscar")
public class BuscarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String usernameBuscado = request.getParameter("usuario");
        Usuario usuarioEncontrado = usuarioDAO.buscarPorUsername(usernameBuscado);

        if(usuarioEncontrado != null) {
            request.setAttribute("usuarioEncontrado", usuarioEncontrado);
        } else {
            request.setAttribute("mensaje", "Usuario buscado no existe");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("buscarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
