package com.horoscopo.dao;

import java.util.List;
import com.horoscopo.modelo.Usuario;

public interface UsuarioDAO {
    public boolean crear(Usuario usuario);
    public Usuario login(String usuario, String password);
    public Usuario buscarPorUsername(String usuario); 
    public boolean modificar(Usuario usuario);
    public boolean eliminar(String usuario);
    public List<Usuario> listarUsuarios();
}
