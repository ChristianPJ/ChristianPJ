package com.inftel.socialnetwork.entity;

/**
 * Created by inftel11 on 18/3/15.
 */
public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String foto;
    private String email;
    private String genero;
    private String locale;
    private String linkGoogle;

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLinkGoogle() {
        return linkGoogle;
    }

    public void setLinkGoogle(String linkGoogle) {
        this.linkGoogle = linkGoogle;
    }
}
