package com.funcionarios.funcionarios.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FuncionarioRequest {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @NotNull(message = "El RUT no puede estar vacío")
    private Integer rut;
    @Email(message = "El correo electrónico no es válido")
    private String email;
    @NotBlank(message = "El dígito verificador no puede estar vacío")
    private String vrut;
    private int grado;

    @NotNull(message = "El ID del departamento no puede estar vacío")
    private Long idDepto;

    @NotNull(message = "El ID del tipo de contrato no puede estar vacío")
    private Long tipoContratoId;
    @NotNull(message = "El ID del escalafón no puede estar vacío")
    private Long escalafonId;

    public Long getTipoContratoId() {
        return tipoContratoId;
    }

    public void setTipoContratoId(Long tipoContratoId) {
        this.tipoContratoId = tipoContratoId;
    }

    public Long getEscalafonId() {
        return escalafonId;
    }

    public void setEscalafonId(Long escalafonId) {
        this.escalafonId = escalafonId;
    }

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

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public Long getIdDepto() {
        return idDepto;
    }

    public void setIdDepto(Long idDepto) {
        this.idDepto = idDepto;
    }

}
