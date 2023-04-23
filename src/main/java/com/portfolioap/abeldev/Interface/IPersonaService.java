package com.portfolioap.abeldev.Interface;

import com.portfolioap.abeldev.entity.Persona;
import java.util.List;

/**
 *
 * @author ABEL DEV
 */

public interface IPersonaService {

    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
