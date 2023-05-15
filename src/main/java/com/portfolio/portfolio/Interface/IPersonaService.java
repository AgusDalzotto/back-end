
package com.portfolio.portfolio.Interface;

import com.portfolio.portfolio.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //agregar persona
    public List <Persona> getPersona();
    
    //Guardar una persona
    
    public void savePersona(Persona persona);
    
    //Eliminar una persona
    
    public void deletePersona(Long id);
    
    //Buscar persona
            
    public Persona findPersona(Long id);
            
            
}
