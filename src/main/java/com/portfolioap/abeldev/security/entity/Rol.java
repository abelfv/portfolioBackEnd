package com.portfolioap.abeldev.security.entity;

import com.portfolioap.abeldev.security.Enums.ActionName;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
