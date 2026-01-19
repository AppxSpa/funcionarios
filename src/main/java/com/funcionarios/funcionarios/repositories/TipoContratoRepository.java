package com.funcionarios.funcionarios.repositories;

import com.funcionarios.funcionarios.entities.TipoContrato;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoContratoRepository extends JpaRepository<TipoContrato, Long> {

    Optional<TipoContrato> findByNombre(String nombre);

    Optional<TipoContrato> findById(Long id);

}
