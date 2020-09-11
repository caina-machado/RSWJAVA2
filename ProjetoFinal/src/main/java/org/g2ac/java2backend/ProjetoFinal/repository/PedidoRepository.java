package org.g2ac.java2backend.ProjetoFinal.repository;

import org.g2ac.java2backend.ProjetoFinal.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
