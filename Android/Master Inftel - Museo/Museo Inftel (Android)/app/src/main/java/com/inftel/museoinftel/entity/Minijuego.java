package com.inftel.museoinftel.entity;

/**
 * Created by inftel18 on 10/3/15.
 */
public class Minijuego {
    private Long Id;
    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private String repuesta3;

    public Minijuego() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public void setRespuesta1(String respuesta1) {
        this.respuesta1 = respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public void setRespuesta2(String respuesta2) {
        this.respuesta2 = respuesta2;
    }

    public String getRepuesta3() {
        return repuesta3;
    }

    public void setRepuesta3(String repuesta3) {
        this.repuesta3 = repuesta3;
    }
}
