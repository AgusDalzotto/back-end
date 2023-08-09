
package com.portfolio.portfolio.Service;

import com.portfolio.portfolio.Entity.Experiencia;
import com.portfolio.portfolio.Entity.Proyectos;
import com.portfolio.portfolio.Repository.RExperiencia;
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
    RProyect rProyectos;
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    
    public Optional<Proyectos> getByNombreE(String nombreE){
        return rProyectos.findByNombreE(nombreE);
    }
    
    public void save(Proyectos proye){
        rProyectos.save(proye);
    }
    
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rProyectos.existsById(id);
    }
