package com.portfolioap.abeldev.security.service;

import com.portfolioap.abeldev.security.entity.Usuario;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolioap.abeldev.security.repository.iUsuarioRepository;

/**
 *
 * @author ABEL DEV
 */
@Service
@Transactional
public class UsuarioService {

    @Autowired
    iUsuarioRepository InterfaceUsuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return InterfaceUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return InterfaceUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public boolean existsByCorreo(String correo) {
        return InterfaceUsuarioRepository.existsByCorreo(correo);
    }

    public void save(Usuario usuario) {
        InterfaceUsuarioRepository.save(usuario);
    }
}
