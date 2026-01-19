package com.funcionarios.funcionarios.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.funcionarios.funcionarios.dto.EscalafonRequest;
import com.funcionarios.funcionarios.services.EscalafonService;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/escalafon")
public class EscalafonController {

    private final EscalafonService escalafonService;

    public EscalafonController(EscalafonService escalafonService) {
        this.escalafonService = escalafonService;
    }

    @PostMapping("/agregar")
    public ResponseEntity<Object> agregarEscalafon(@RequestBody EscalafonRequest request) {
        escalafonService.agregarEscalafon(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Escalafón agregado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerEscalafonPorId(@PathVariable Long id) {
        return ResponseEntity.ok(escalafonService.obtenerEscalafonById(id));

    }

    @GetMapping("/todos")
    public ResponseEntity<Object> obtenerTodosLosEscalafones() {
        return ResponseEntity.ok(escalafonService.obtenerTodosLosEscalafones());
    }
}
