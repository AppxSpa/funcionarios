package com.funcionarios.funcionarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.funcionarios.funcionarios.dto.FuncionarioRequest;
import com.funcionarios.funcionarios.dto.FuncionarioResponse;
import com.funcionarios.funcionarios.entities.Funcionario;
import com.funcionarios.funcionarios.exceptions.EscalafonException;
import com.funcionarios.funcionarios.exceptions.FuncionarioExceptions;
import com.funcionarios.funcionarios.exceptions.NotFoundFuncionarioException;
import com.funcionarios.funcionarios.exceptions.TipoContratoException;
import com.funcionarios.funcionarios.mappers.FuncionarioMappers;
import com.funcionarios.funcionarios.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMappers funcionarioMappers;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository, FuncionarioMappers funcionarioMappers) {
        this.funcionarioRepository = funcionarioRepository;
        this.funcionarioMappers = funcionarioMappers;
    }

    @Override
    public void agregarFuncionario(FuncionarioRequest request) {

        Optional<Funcionario> existingFuncionario = funcionarioRepository.findByRut(request.getRut());

        try {
            if (existingFuncionario.isPresent()) {
                Funcionario funcionarioToUpdate = existingFuncionario.get();
                Funcionario updatedFuncionario = funcionarioMappers.updateFuncionarioFromRequest(funcionarioToUpdate,
                        request);
                funcionarioRepository.save(updatedFuncionario);
            } else {
                Funcionario newFuncionario = funcionarioMappers.mapToEntity(request);
                funcionarioRepository.save(newFuncionario);
            }
        } catch (EscalafonException | TipoContratoException e) {
            throw new FuncionarioExceptions(e.getMessage());
        }
    }

    @Override
    public FuncionarioResponse obtenerFuncionarioPorRut(Integer rut) {
        return funcionarioRepository.findByRut(rut)
                .map(funcionarioMappers::mapToResponse)
                .orElseThrow(() -> new NotFoundFuncionarioException("Funcionario no encontrado con RUT: " + rut));
    }

    @Override
    public List<FuncionarioResponse> listarFuncionarios() {
        return funcionarioRepository.findAll().stream()
                .map(funcionarioMappers::mapToResponse)
                .toList();
    }

}
