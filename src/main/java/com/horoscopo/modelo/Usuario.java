package com.horoscopo.modelo;

import java.util.Date;

public class Usuario {
    private String nombre;
    private String usuario;       // nombre de usuario (username)
    private String email;
    private Date fechaNacimiento;
    private String password;
    private String animalHoroscopo; // para guardar el signo/animal que se calcule

    public Usuario() {
    }

    public Usuario(String nombre, String usuario, String email, Date fechaNacimiento, String password, String animalHoroscopo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.animalHoroscopo = animalHoroscopo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAnimalHoroscopo() {
        return animalHoroscopo;
    }
    public void setAnimalHoroscopo(String animalHoroscopo) {
        this.animalHoroscopo = animalHoroscopo;
    }
}


