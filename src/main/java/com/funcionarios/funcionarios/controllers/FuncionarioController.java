package com.funcionarios.funcionarios.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcionarios.funcionarios.services.FuncionarioService;

import jakarta.validation.Valid;

import com.funcionarios.funcionarios.dto.FuncionarioRequest;
import com.funcionarios.funcionarios.exceptions.FuncionarioExceptions;
import com.funcionarios.funcionarios.helpers.FuncionarioHelp;
import com.funcionarios.funcionarios.mappers.ErrorValidationMapper;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;
    private final ErrorValidationMapper errorValidationMapper;
    private static final String RUT_INVALIDO = "RUT inválido.";
    private static final String FUNCIONARIO_AGREGADO = "Funcionario agregado o actualizado exitosamente.";

    public FuncionarioController(FuncionarioService funcionarioService, ErrorValidationMapper errorValidationMapper) {
        this.funcionarioService = funcionarioService;
        this.errorValidationMapper = errorValidationMapper;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Object> agregarFuncionario(@Valid @RequestBody FuncionarioRequest request,
            BindingResult result)
            throws FuncionarioExceptions {

        if (result.hasErrors()) {
            return manejarErrorValidacion(result);
        }

        if (esRutValido(request.getRut(), request.getVrut())) {
            throw new FuncionarioExceptions(RUT_INVALIDO);
        }
        funcionarioService.agregarFuncionario(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(FUNCIONARIO_AGREGADO);
    }

    @GetMapping("/{rut}")
    public ResponseEntity<Object> obtenerFuncionarioPorRut(@PathVariable Integer rut) throws FuncionarioExceptions {
        if (esRutValido(rut, FuncionarioHelp.calcularVrut(rut))) {
            throw new FuncionarioExceptions(RUT_INVALIDO);
        }

        return ResponseEntity.ok(funcionarioService.obtenerFuncionarioPorRut(rut));
    }

    @GetMapping("/listar")
    public ResponseEntity<Object> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    protected ResponseEntity<Object> manejarErrorValidacion(BindingResult result) {

        return ResponseEntity.badRequest().body(errorValidationMapper.mapValidationErrors(result));
    }

    private boolean esRutValido(Integer rut, String vrut) {
        return !FuncionarioHelp.validarRut(rut, vrut);
    }

}
