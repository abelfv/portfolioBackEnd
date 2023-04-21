package com.portfolioap.abeldev.security.service;

import com.portfolioap.abeldev.security.Enums.ActionName;
import com.portfolioap.abeldev.security.entity.Rol;
import com.portfolioap.abeldev.security.repository.InterfaceRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ABEL DEV
 */
@Service
@Transactional
public class RolService {

    @Autowired
    InterfaceRolRepository interfaceRolRepository;

    public Optional<Rol> getByRolNombre(ActionName actionName) {
        return interfaceRolRepository.findByRolNombre(actionName);
    }

    public void save(Rol rol) {
        interfaceRolRepository.save(rol);
    }
}
