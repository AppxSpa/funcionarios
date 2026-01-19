package com.funcionarios.funcionarios.services;

import com.funcionarios.funcionarios.dto.EscalafonRequest;
import com.funcionarios.funcionarios.dto.EscalafonResponse;
import com.funcionarios.funcionarios.entities.Escalafon;
import com.funcionarios.funcionarios.exceptions.EscalafonException;
import com.funcionarios.funcionarios.mappers.EscalafonMapper;
import com.funcionarios.funcionarios.repositories.EscalafonRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EscalafonServiceImpl implements EscalafonService {

    private final EscalafonRepository escalafonRepository;
    private final EscalafonMapper escalafonMapper;

    public EscalafonServiceImpl(EscalafonRepository escalafonRepository, EscalafonMapper escalafonMapper) {
        this.escalafonRepository = escalafonRepository;
        this.escalafonMapper = escalafonMapper;
    }

    @Override
    public void agregarEscalafon(EscalafonRequest request) {

        Optional<Escalafon> escalafonOpt = escalafonRepository.findByNombre(request.getNombre());

        if (escalafonOpt.isPresent()) {
            Escalafon existingEscalafon = escalafonOpt.get();
            Escalafon updatedEscalafon = escalafonMapper.updateEntityFromRequest(existingEscalafon, request);
            escalafonRepository.save(updatedEscalafon);
        } else {
            escalafonRepository.save(escalafonMapper.mapToEntity(request));
        }

    }

    @Override
    public EscalafonResponse obtenerEscalafonById(Long id) {
        Optional<Escalafon> escalafonOpt = escalafonRepository.findById(id);
        if (escalafonOpt.isPresent()) {
            Escalafon escalafon = escalafonOpt.get();
            return escalafonMapper.mapToResponse(escalafon);
        } else {
            throw new EscalafonException("Escalafon con ID " + id + " no encontrado");
        }
    }

    @Override
    public List<EscalafonResponse> obtenerTodosLosEscalafones() {
        List<Escalafon> escalafones = escalafonRepository.findAll();
        return escalafones.stream()
                .map(escalafonMapper::mapToResponse)
                .toList();
    }

}
