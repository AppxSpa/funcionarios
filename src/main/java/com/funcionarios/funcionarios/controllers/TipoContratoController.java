package com.funcionarios.funcionarios.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funcionarios.funcionarios.dto.TipoContratoRequest;
import com.funcionarios.funcionarios.services.TipoContratoService;

@RestController
@RequestMapping("/tipocontrato")
public class TipoContratoController {

    private final TipoContratoService tipoContratoService;
    private static final String FUNCIONARIO_OK = "Tipo contrato actualizdo o creado correctamente";

    public TipoContratoController(TipoContratoService tipoContratoService) {
        this.tipoContratoService = tipoContratoService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Object> agregarTipoContrato(@RequestBody TipoContratoRequest request) {
        tipoContratoService.agregarTipoContrato(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(FUNCIONARIO_OK);
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Object> obtenerTipoContratoPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(tipoContratoService.obtenerTipoContratoPorNombre(nombre));
    }

    @GetMapping("/todos")
    public ResponseEntity<Object> obtenerTodosLosTiposContrato() {
        return ResponseEntity.ok(tipoContratoService.obtenerTodosLosTiposContrato());   
    }
}
