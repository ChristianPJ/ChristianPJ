package com.inftel.socialnetwork.entity;

public class Groups {

    private String id;
    private String name;
    private String imageUrl;
    private String email;
    private String userName;
    private String fotoUrl;
    private boolean creador;

    public Groups(){}

    public Groups(String id, String name, String imageUrl, String email, String userName, String fotoUrl, boolean creador) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.userName = userName;
        this.fotoUrl = fotoUrl;
        this.creador = creador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public boolean isCreador() {
        return creador;
    }

    public void setCreador(boolean creador) {
        this.creador = creador;
    }
}
