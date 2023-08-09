
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Entity.Proyectos;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.portfolio.Repository.RProyect;


@Service
@Transactional
public class SProyectos {
    @Autowired
    RProyect rProyect;
    
    public List<Proyectos> list(){
        return rProyect.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return rProyect.findById(id);
    }
    
    public Optional<Proyectos> getByNombreE(String nombreE){
        return rProyect.findByNombreE(nombreE);
    }
    
    public void save(Proyectos proye){
        rProyect.save(proye);
    }
    
    public void delete(int id){
        rProyect.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyect.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rProyect.existsByNombreE(nombreE);
    }
}
