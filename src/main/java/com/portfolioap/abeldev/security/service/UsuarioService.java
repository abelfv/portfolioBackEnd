package com.portfolioap.abeldev.security.service;

import com.portfolioap.abeldev.entity.Persona;
import com.portfolioap.abeldev.security.repository.interfaceUsuarioRepository;
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
public class UsuarioService {
    @Autowired
    interfaceUsuarioRepository InterfaceUsuarioRepository;
    
    public Optional<Persona> getByNombreUsuario(String nombreUsuario){
    return InterfaceUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
    return InterfaceUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByCorreo(String correo){
    return InterfaceUsuarioRepository.existsByCorreo(correo);
    }
    
    public void save(Persona usuario){
    InterfaceUsuarioRepository.save(usuario);
    }
}
