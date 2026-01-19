package com.funcionarios.funcionarios.dto;

public class TipoContratoResponse {

    private Long id;
    private String nombre;
    private boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public TipoContratoResponse() {
    }

    public TipoContratoResponse(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}