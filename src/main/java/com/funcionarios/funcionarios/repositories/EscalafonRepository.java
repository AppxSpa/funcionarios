package com.funcionarios.funcionarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.funcionarios.funcionarios.entities.Escalafon;
import java.util.Optional;

public interface EscalafonRepository extends JpaRepository<Escalafon, Long> {

    Optional<Escalafon> findByNombre(String nombre);

}
