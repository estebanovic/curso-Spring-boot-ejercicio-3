package com.example.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Usuario {

    @NotEmpty(message = "El nombre no puede estar vacio")
    private String nombre;

    @NotEmpty
    private String apellido;

    @Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    private String identificador;

    @NotEmpty
    @Size(min = 3, max = 10)
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email(message = "El formato no es valido")
    private String email;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String identificador, String username, String password, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificador = identificador;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
