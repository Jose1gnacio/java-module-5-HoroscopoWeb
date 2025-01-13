package com.horoscopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.horoscopo.modelo.Usuario;
import com.horoscopo.procesaconexion.ConexionManager;
import java.sql.Date;
import java.sql.SQLException;

public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public boolean crear(Usuario usuario) {
        boolean creado = false;
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        String sql = "INSERT INTO PERSONA (NOMBRE, USUARIO, EMAIL, FECHA_NACIMIENTO, PASSWORD, ANIMAL_HOROSCOPO) "
                   + "VALUES (?,?,?,?,?,?)";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getUsuario());
            pstm.setString(3, usuario.getEmail());
            // Convert java.util.Date a java.sql.Date
            pstm.setDate(4, new Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(5, usuario.getPassword());
            pstm.setString(6, usuario.getAnimalHoroscopo());
            
            int filas = pstm.executeUpdate();
            if(filas > 0) {
                creado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return creado;
    }

    @Override
    public Usuario login(String username, String password) {
        Usuario user = null;
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PERSONA WHERE USUARIO=? AND PASSWORD=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if(rs.next()) {
                user = new Usuario();
                user.setNombre(rs.getString("NOMBRE"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAnimalHoroscopo(rs.getString("ANIMAL_HOROSCOPO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        Usuario user = null;
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PERSONA WHERE USUARIO=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();
            if(rs.next()) {
                user = new Usuario();
                user.setNombre(rs.getString("NOMBRE"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAnimalHoroscopo(rs.getString("ANIMAL_HOROSCOPO"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean modificar(Usuario usuario) {
        boolean modificado = false;
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        String sql = "UPDATE PERSONA SET NOMBRE=?, EMAIL=?, FECHA_NACIMIENTO=?, PASSWORD=?, ANIMAL_HOROSCOPO=? "
                   + "WHERE USUARIO=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNombre());
            pstm.setString(2, usuario.getEmail());
            pstm.setDate(3, new Date(usuario.getFechaNacimiento().getTime()));
            pstm.setString(4, usuario.getPassword());
            pstm.setString(5, usuario.getAnimalHoroscopo());
            pstm.setString(6, usuario.getUsuario());
            
            int filas = pstm.executeUpdate();
            if(filas > 0) {
                modificado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modificado;
    }

    @Override
    public boolean eliminar(String username) {
        boolean eliminado = false;
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        String sql = "DELETE FROM PERSONA WHERE USUARIO=?";
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            int filas = pstm.executeUpdate();
            if(filas > 0) {
                eliminado = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eliminado;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        Connection conn = ConexionManager.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM PERSONA";
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
                Usuario user = new Usuario();
                user.setNombre(rs.getString("NOMBRE"));
                user.setUsuario(rs.getString("USUARIO"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setAnimalHoroscopo(rs.getString("ANIMAL_HOROSCOPO"));
                lista.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
