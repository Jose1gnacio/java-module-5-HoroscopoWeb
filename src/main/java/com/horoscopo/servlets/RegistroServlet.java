package com.horoscopo.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

import com.horoscopo.dao.UsuarioDAO;
import com.horoscopo.dao.UsuarioDAOImpl;
import com.horoscopo.modelo.Usuario;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDAO = new UsuarioDAOImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Recibir datos del formulario
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String email = request.getParameter("email");
        String fechaNac = request.getParameter("fechaNac");
        String password = request.getParameter("password");

        // 2. Parsear fecha de nacimiento
        Date fechaNacimiento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaNacimiento = sdf.parse(fechaNac);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. Calcular el animal del horóscopo chino antes de insertar
        String animal = "";
        if (fechaNacimiento != null) {
            // Obtener el año
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaNacimiento);
            int year = cal.get(Calendar.YEAR);
            int resto = year % 12;
            switch (resto) {
                case 0:  animal = "Mono";      break;
                case 1:  animal = "Gallo";     break;
                case 2:  animal = "Perro";     break;
                case 3:  animal = "Cerdo";     break;
                case 4:  animal = "Rata";      break;
                case 5:  animal = "Buey";      break;
                case 6:  animal = "Tigre";     break;
                case 7:  animal = "Conejo";    break;
                case 8:  animal = "Dragon";    break;
                case 9:  animal = "Serpiente"; break;
                case 10: animal = "Caballo";   break;
                case 11: animal = "Cabra";     break;
            }
        }

        // 4. Crear objeto Usuario con el animal calculado (no nulo)
        Usuario nuevo = new Usuario(nombre, usuario, email, fechaNacimiento, password, animal);

        // 5. Guardar en la BD
        boolean creado = usuarioDAO.crear(nuevo);
        if(creado) {
            request.setAttribute("mensaje", "Usuario registrado con éxito. Tu signo es: " + animal);
            // Redirigir a login.jsp
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("mensaje", "Error al registrar usuario");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}
