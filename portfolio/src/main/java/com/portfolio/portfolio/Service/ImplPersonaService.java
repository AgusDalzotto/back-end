package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Entity.Persona;
import com.portfolio.portfolio.Interface.IPersonaService;
import com.portfolio.portfolio.Repository.IPersonaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImplPersonaService implements IPersonaService {    
    @Autowired IPersonaRepository ipersonarepository;

    @Override
    public List<Persona> getPersona() {
       List<Persona> persona = ipersonarepository.findAll();
       return persona;
    }

    @Override
    public void savePersona(Persona persona) {
        ipersonarepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonarepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = ipersonarepository.findById(id).orElse(null);
        return persona;    
    }   
}
