package com.funcionarios.funcionarios.mappers;

import org.springframework.stereotype.Component;

import com.funcionarios.funcionarios.dto.TipoContratoRequest;
import com.funcionarios.funcionarios.dto.TipoContratoResponse;
import com.funcionarios.funcionarios.entities.TipoContrato;

@Component
public class TipoContratoMapper {

    public TipoContrato mapToEntity(TipoContratoRequest request) {
        TipoContrato tipoContrato = new TipoContrato();
        tipoContrato.setNombre(request.getNombre());
        tipoContrato.setActivo(request.isActivo());
        return tipoContrato;
    }

    public TipoContrato updateEntityFromRequest(TipoContrato tipoContrato, TipoContratoRequest request) {
        tipoContrato.setNombre(request.getNombre());
        return tipoContrato;
    }

    public TipoContratoResponse mapToResponse(TipoContrato tipoContrato) {
        TipoContratoResponse response = new TipoContratoResponse();
        response.setId(tipoContrato.getId());
        response.setNombre(tipoContrato.getNombre());
        response.setActivo(tipoContrato.isActivo());
        return response;
    }

}
