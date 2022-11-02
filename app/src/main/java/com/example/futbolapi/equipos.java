package com.example.futbolapi;

import java.io.Serializable;

public class equipos implements Serializable {

    private Integer id;
    private String nombre;
    private String fundacion;
    private String presidente;
    private String estadio;
    private String imagen;
    private String detailsURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetailsURL() {
        return detailsURL;
    }

    public void setDetailsURL(String detailsURL) {
        this.detailsURL = detailsURL;
    }
}

