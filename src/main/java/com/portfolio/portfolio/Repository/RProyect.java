
package com.portfolio.portfolio.Repository;

import com.portfolio.portfolio.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RProyect extends JpaRepository<Proyectos, Integer> {
    public Optional<Proyectos> findByNombreE(String nombreE);
    public boolean existsByNombreE(String nombreE);
}
