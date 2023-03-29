
package com.portfolio.portfolio.Controler;

import com.portfolio.portfolio.Entity.Persona;
import com.portfolio.portfolio.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService ipersonaService;
    
    @GetMapping("personas/traer")
    public List <Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona fue creada exitosamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "la persona se elimino exitosamente";
    }
    
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("nombre") String nuevoNombre
                                @RequestParam ("nombre") String nuevoNombre)                                                                                 )
    
}

