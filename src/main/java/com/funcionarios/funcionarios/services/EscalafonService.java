package com.funcionarios.funcionarios.services;

import java.util.List;

import com.funcionarios.funcionarios.dto.EscalafonRequest;
import com.funcionarios.funcionarios.dto.EscalafonResponse;

public interface EscalafonService {

    void agregarEscalafon(EscalafonRequest request);

    EscalafonResponse obtenerEscalafonById(Long id);

    List<EscalafonResponse> obtenerTodosLosEscalafones();

}
