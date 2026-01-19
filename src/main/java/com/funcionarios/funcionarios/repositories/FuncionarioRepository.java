package com.funcionarios.funcionarios.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.funcionarios.funcionarios.entities.Funcionario;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByRut(Integer rut);

}
