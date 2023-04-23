package com.portfolioap.abeldev.security.controller;

import com.portfolioap.abeldev.security.Enums.ActionName;
import com.portfolioap.abeldev.security.dto.LoginUsuario;
import com.portfolioap.abeldev.security.dto.JwtDto;
import com.portfolioap.abeldev.security.dto.NuevoUsuario;
import com.portfolioap.abeldev.security.entity.Rol;
import com.portfolioap.abeldev.security.entity.Usuario;
import com.portfolioap.abeldev.security.jwt.jwtProvider;
import com.portfolioap.abeldev.security.service.RolService;
import com.portfolioap.abeldev.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ABEL DEV
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    PasswordEncoder PasswordEncoder;
    @Autowired
    AuthenticationManager AuthenticationManager;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    RolService rolService;
    @Autowired
    jwtProvider jwtProvider;

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new mensaje("CORREO NO VALIDO O CAMPOS INCORRECTOS"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())) {
            return new ResponseEntity(new mensaje("USUARIO YA EXISTENTE"), HttpStatus.BAD_REQUEST);
        }

        if (usuarioService.existsByCorreo(nuevoUsuario.getCorreo())) {
            return new ResponseEntity(new mensaje("CORREO YA EXISTENTE"), HttpStatus.BAD_REQUEST);
        }
     
        Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getNombreUsuario(), nuevoUsuario.getCorreo(), PasswordEncoder.encode(nuevoUsuario.getContraseña()));

        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolNombre(ActionName.ROLE_USER).get());

        if (nuevoUsuario.getRoles().contains("admin")) 
            roles.add(rolService.getByRolNombre(ActionName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        usuarioService.save(usuario);
        
        return new ResponseEntity(new mensaje("USUARIO GUARDADO"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new mensaje("CAMPOS INCORRECTOS"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = AuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getContraseña()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
