package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;
import com.horoscopo.modelo.Usuario;

@WebServlet("/modificar")
public class ModificarUsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Solo permitir si hay sesión iniciada
        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("usuarioLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Datos del formulario
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String fechaNac = request.getParameter("fechaNac");
        String password = request.getParameter("password");
        String animal = request.getParameter("animal");

        Date fechaNacimiento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNacimiento = sdf.parse(fechaNac);
        } catch(Exception e) {
            e.printStackTrace();
        }

        Usuario u = new Usuario(nombre, usuario, email, fechaNacimiento, password, animal);

        boolean actualizado = usuarioDAO.modificar(u);
        if(actualizado) {
            request.setAttribute("mensaje", "Usuario modificado exitosamente");
        } else {
            request.setAttribute("mensaje", "No se pudo modificar");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("modificarUsuario.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
