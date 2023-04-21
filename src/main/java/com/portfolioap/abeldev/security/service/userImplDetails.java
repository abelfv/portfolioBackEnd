package com.portfolioap.abeldev.security.service;

import com.portfolioap.abeldev.entity.Persona;
import com.portfolioap.abeldev.security.entity.primerUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ABEL DEV
 */

@Service
public class userImplDetails implements UserDetailsService{
   @Autowired
   UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
    Persona usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
    return primerUsuario.build(usuario);
    }
}
