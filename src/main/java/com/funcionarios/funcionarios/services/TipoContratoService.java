package com.funcionarios.funcionarios.services;

import java.util.List;

import com.funcionarios.funcionarios.dto.TipoContratoRequest;
import com.funcionarios.funcionarios.dto.TipoContratoResponse;
import com.funcionarios.funcionarios.exceptions.NotFoundTipoContratoException;

public interface TipoContratoService {

    void agregarTipoContrato(TipoContratoRequest request);

    TipoContratoResponse obtenerTipoContratoPorNombre(String nombre) throws NotFoundTipoContratoException;

    List<TipoContratoResponse> obtenerTodosLosTiposContrato();

}
