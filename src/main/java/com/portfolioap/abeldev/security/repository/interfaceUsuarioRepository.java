package com.portfolioap.abeldev.security.repository;

import com.portfolioap.abeldev.entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ABEL DEV
 */

@Repository
public interface interfaceUsuarioRepository extends JpaRepository<Persona, Integer>{
    Optional<Persona> findByNombreUsuario(String nombreUsuario);
    
    boolean existsByNombreUsuario(String nombreUsuario);
    boolean existsByCorreo(String correo);
}
