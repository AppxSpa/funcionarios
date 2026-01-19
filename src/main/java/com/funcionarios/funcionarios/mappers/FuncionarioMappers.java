package com.funcionarios.funcionarios.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.funcionarios.funcionarios.dto.FuncionarioRequest;
import com.funcionarios.funcionarios.dto.FuncionarioResponse;
import com.funcionarios.funcionarios.entities.Escalafon;
import com.funcionarios.funcionarios.entities.Funcionario;
import com.funcionarios.funcionarios.entities.TipoContrato;
import com.funcionarios.funcionarios.exceptions.EscalafonException;
import com.funcionarios.funcionarios.exceptions.FuncionarioExceptions;
import com.funcionarios.funcionarios.exceptions.NotFoundTipoContratoException;
import com.funcionarios.funcionarios.exceptions.TipoContratoException;
import com.funcionarios.funcionarios.helpers.FuncionarioHelp;
import com.funcionarios.funcionarios.repositories.EscalafonRepository;
import com.funcionarios.funcionarios.repositories.TipoContratoRepository;
import com.funcionarios.funcionarios.exceptions.NotFoundEscalafonException;

@Component
public class FuncionarioMappers {

    private final TipoContratoRepository tipoContratoRepository;
    private final EscalafonRepository escalafonRepository;

    public FuncionarioMappers(TipoContratoRepository tipoContratoRepository,
            EscalafonRepository escalafonRepository) {
        this.tipoContratoRepository = tipoContratoRepository;
        this.escalafonRepository = escalafonRepository;
    }

    public Funcionario mapToEntity(FuncionarioRequest request) throws TipoContratoException, NotFoundTipoContratoException, NotFoundEscalafonException {
        Funcionario funcionario = new Funcionario();
        funcionario.setRut(request.getRut());
        funcionario.setVrut(request.getVrut());
        funcionario.setTipoContrato(getTipoContratoById(request.getTipoContratoId()));
        funcionario.setEscalafon(getEscalafonById(request.getEscalafonId()));
        funcionario.setGrado(request.getGrado());
        funcionario.setIdDepto(request.getIdDepto());
        funcionario.setNombres(toUpper(request.getNombres()));
        funcionario.setApellidoPaterno(toUpper(request.getApellidoPaterno()));
        funcionario.setApellidoMaterno(toUpper(request.getApellidoMaterno()));
        validarCorreo(request.getEmail());
        funcionario.setEmail(request.getEmail());
        return funcionario;
    }

    public Funcionario updateFuncionarioFromRequest(Funcionario funcionario, FuncionarioRequest request) throws NotFoundTipoContratoException, NotFoundEscalafonException {
        funcionario.setTipoContrato(getTipoContratoById(request.getTipoContratoId()));
        funcionario.setEscalafon(getEscalafonById(request.getEscalafonId()));
        funcionario.setGrado(request.getGrado());
        funcionario.setIdDepto(request.getIdDepto());
        funcionario.setNombres(toUpper(request.getNombres()));
        funcionario.setApellidoPaterno(toUpper(request.getApellidoPaterno()));
        funcionario.setApellidoMaterno(toUpper(request.getApellidoMaterno()));
        validarCorreo(request.getEmail());
        funcionario.setEmail(request.getEmail());
        return funcionario;
    }

    public FuncionarioResponse mapToResponse(Funcionario funcionario) {
        FuncionarioResponse response = new FuncionarioResponse();
        response.setRut(funcionario.getRut());
        response.setVrut(funcionario.getVrut());
        response.setTipoContrato(funcionario.nombreTipoContrato());
        response.setEscalafon(funcionario.nombreEscalafon());
        response.setGrado(funcionario.getGrado());
        response.setNombres(funcionario.getNombres());
        response.setApellidoPaterno(funcionario.getApellidoPaterno());
        response.setApellidoMaterno(funcionario.getApellidoMaterno());
        response.setEmail(funcionario.getEmail());
        return response;
    }

    private void validarCorreo(String email) {
        if (!FuncionarioHelp.validarEmail(email)) {
            throw new FuncionarioExceptions("El correo electrónico no es válido.");
        }
    }

    private String toUpper(String str) {
        return str != null ? str.toUpperCase() : null;
    }

    private Escalafon getEscalafonById(Long id) throws EscalafonException {
        Optional<Escalafon> escalafon = escalafonRepository.findById(id);
        if (escalafon.isPresent()) {
            return escalafon.get();
        } else {
            throw new NotFoundEscalafonException("Escalafón no encontrado con ID: " + id);
        }
    }

    private TipoContrato getTipoContratoById(Long id) throws NotFoundTipoContratoException {
        Optional<TipoContrato> tipoContrato = tipoContratoRepository.findById(id);
        if (tipoContrato.isPresent()) {
            return tipoContrato.get();
        } else {
            throw new NotFoundTipoContratoException("Tipo de contrato no encontrado con ID: " + id);
        }
    }

}
