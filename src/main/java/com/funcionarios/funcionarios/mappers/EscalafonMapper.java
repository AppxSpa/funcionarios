package com.funcionarios.funcionarios.mappers;

import org.springframework.stereotype.Component;

import com.funcionarios.funcionarios.dto.EscalafonRequest;
import com.funcionarios.funcionarios.dto.EscalafonResponse;
import com.funcionarios.funcionarios.entities.Escalafon;

@Component
public class EscalafonMapper {

    public Escalafon mapToEntity(EscalafonRequest request) {
        Escalafon escalafon = new Escalafon();
        escalafon.setNombre(request.getNombre());
        escalafon.setActivo(request.isActivo());
        return escalafon;
    }

    public Escalafon updateEntityFromRequest(Escalafon existingEscalafon, EscalafonRequest request) {
        existingEscalafon.setNombre(request.getNombre());
        existingEscalafon.setActivo(request.isActivo());
        return existingEscalafon;
    }

    public EscalafonResponse mapToResponse(Escalafon escalafon) {
        EscalafonResponse response = new EscalafonResponse();
        response.setId(escalafon.getId());
        response.setNombre(escalafon.getNombre());
        response.setActivo(escalafon.isActivo());
        return response;
    }

}
