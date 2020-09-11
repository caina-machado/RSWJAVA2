package org.g2ac.java2backend.ProjetoFinal.repository;

import org.g2ac.java2backend.ProjetoFinal.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
