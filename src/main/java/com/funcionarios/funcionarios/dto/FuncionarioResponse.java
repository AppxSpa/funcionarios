package com.funcionarios.funcionarios.dto;


public class FuncionarioResponse {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer rut;
    private String email;
    private String vrut;
    private String tipoContrato;
    private String escalafon;
    private int grado;
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public Integer getRut() {
        return rut;
    }
    public void setRut(Integer rut) {
        this.rut = rut;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getVrut() {
        return vrut;
    }
    public void setVrut(String vrut) {
        this.vrut = vrut;
    }
    public String getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    public String getEscalafon() {
        return escalafon;
    }
    public void setEscalafon(String escalafon) {
        this.escalafon = escalafon;
    }
    public int getGrado() {
        return grado;
    }
    public void setGrado(int grado) {
        this.grado = grado;
    }

    

}
