package com.portfolioap.abeldev.security.dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author ABEL DEV
 */

public class LoginUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String contraseña;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    } 
}
