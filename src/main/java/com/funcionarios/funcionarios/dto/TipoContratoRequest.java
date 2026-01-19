package com.funcionarios.funcionarios.dto;

import jakarta.validation.constraints.NotNull;

public class TipoContratoRequest {

    @NotNull(message = "El nombre no puede estar vacío")
    private String nombre;
    private boolean activo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
