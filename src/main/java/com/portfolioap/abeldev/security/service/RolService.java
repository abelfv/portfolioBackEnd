package com.portfolioap.abeldev.security.service;

import com.portfolioap.abeldev.security.Enums.RolNombre;
import com.portfolioap.abeldev.security.entity.Rol;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolioap.abeldev.security.repository.iRolRepository;

/**
 *
 * @author ABEL DEV
 */
@Service
@Transactional
public class RolService {

    @Autowired
    iRolRepository interfaceRolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return interfaceRolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        interfaceRolRepository.save(rol);
    }
}
