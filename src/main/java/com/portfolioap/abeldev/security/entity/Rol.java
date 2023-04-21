package com.portfolioap.abeldev.security.entity;

import com.portfolioap.abeldev.security.Enums.ActionName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ABEL DEV
 */

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ActionName rolNombre;

    public Rol() {
    }

    public Rol(ActionName rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ActionName getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(ActionName rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
}
