package com.portfolioap.abeldev.security.repository;

import com.portfolioap.abeldev.security.Enums.ActionName;
import com.portfolioap.abeldev.security.entity.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ABEL DEV
 */
@Repository
public interface InterfaceRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(ActionName actionName);
}
