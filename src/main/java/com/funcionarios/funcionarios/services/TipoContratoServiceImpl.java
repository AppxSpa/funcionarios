package com.funcionarios.funcionarios.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.funcionarios.funcionarios.dto.TipoContratoRequest;
import com.funcionarios.funcionarios.dto.TipoContratoResponse;
import com.funcionarios.funcionarios.entities.TipoContrato;
import com.funcionarios.funcionarios.exceptions.NotFoundTipoContratoException;
import com.funcionarios.funcionarios.repositories.TipoContratoRepository;
import com.funcionarios.funcionarios.mappers.TipoContratoMapper;

@Service
public class TipoContratoServiceImpl implements TipoContratoService {

    private final TipoContratoRepository tipoContratoRepository;
    private final TipoContratoMapper tipoContratoMapper;

    public TipoContratoServiceImpl(TipoContratoRepository tipoContratoRepository,
            TipoContratoMapper tipoContratoMapper) {
        this.tipoContratoRepository = tipoContratoRepository;
        this.tipoContratoMapper = tipoContratoMapper;
    }

    @Override
    public void agregarTipoContrato(TipoContratoRequest request) {

        Optional<TipoContrato> existing = tipoContratoRepository.findByNombre(request.getNombre());

        if (existing.isPresent()) {
            TipoContrato existingTipoContrato = existing.get();
            TipoContrato updatedTipoContrato = tipoContratoMapper.updateEntityFromRequest(existingTipoContrato,
                    request);
            tipoContratoRepository.save(updatedTipoContrato);
        } else {
            TipoContrato contrato = tipoContratoMapper.mapToEntity(request);
            tipoContratoRepository.save(contrato);
        }

    }

    @Override
    public TipoContratoResponse obtenerTipoContratoPorNombre(String nombre) {
        Optional<TipoContrato> tipoContratoOpt = tipoContratoRepository.findByNombre(nombre);
        if (tipoContratoOpt.isPresent()) {
            TipoContrato tipoContrato = tipoContratoOpt.get();
            return new TipoContratoResponse(tipoContrato.getNombre());
        } else {
            throw new NotFoundTipoContratoException("TipoContrato " + nombre + " no encontrado");
        }

    }

    @Override
    public List<TipoContratoResponse> obtenerTodosLosTiposContrato() {
        List<TipoContrato> tiposContrato = tipoContratoRepository.findAll();
        return tiposContrato.stream()
                .map(tipoContratoMapper::mapToResponse)
                .toList();
    }
}
