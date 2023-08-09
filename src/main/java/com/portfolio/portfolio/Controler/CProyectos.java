
package com.portfolio.portfolio.Controler;

import com.portfolio.portfolio.Dto.dtoExperiencia;
import com.portfolio.portfolio.Dto.dtoProyectos;
import com.portfolio.portfolio.Entity.Experiencia;
import com.portfolio.portfolio.Entity.Proyectos;
import com.portfolio.portfolio.Security.Controller.Mensaje;
import com.portfolio.portfolio.Service.SProyectos;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/proyects")
@CrossOrigin(origins = "https://frontendarg-1de98.web.app")
public class CProyectos {
    @Autowired
    SProyectos sProyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> lis(){
        List<Proyectos> list = sProyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproye){
        if (StringUtils.isBlank(dtoproye.getNombreE()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (sProyectos.existsByNombreE(dtoproye.getNombreE()))
            return new ResponseEntity(new Mensaje ("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = new  Proyectos(dtoproye.getNombreE(), dtoproye.getDescripcionE(), dtoproye.getImg());
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje("El proyecto ha sido agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexp){
        //validacion de existencia del id
        if (!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        //compara experiencias
        if (sProyectos.existsByNombreE(dtoexp.getNombreE()) && sProyectos.getByNombreE(dtoexp.getNombreE()).get().getId() != id)
            return new ResponseEntity(new Mensaje ("Ese proyecto ya ha sido cargado"), HttpStatus.BAD_REQUEST);
        //indica que no puede estar vacio
        if (StringUtils.isBlank(dtoexp.getNombreE()))
            return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = sProyectos.getOne(id).get();
        proyectos.setNombreE(dtoexp.getNombreE());
        proyectos.setDescripcionE(dtoexp.getDescripcionE());
        
        sProyectos.save(proyectos);
        
        return new ResponseEntity(new Mensaje ("El proyecto ha sido actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") int id){
        //validacion de existencia del id
        if (!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje ("El ID no existe"), HttpStatus.BAD_REQUEST);
        
        sProyectos.delete(id);
        
        return new ResponseEntity(new Mensaje("El proyecto ha sido eliminado"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sProyectos.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyectos = sProyectos.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
