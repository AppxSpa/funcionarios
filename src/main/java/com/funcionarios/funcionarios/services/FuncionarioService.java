package com.funcionarios.funcionarios.services;

import java.util.List;

import com.funcionarios.funcionarios.dto.FuncionarioRequest;
import com.funcionarios.funcionarios.dto.FuncionarioResponse;

public interface FuncionarioService {

    void agregarFuncionario(FuncionarioRequest request);

    FuncionarioResponse obtenerFuncionarioPorRut(Integer rut);

    List<FuncionarioResponse> listarFuncionarios();

}
