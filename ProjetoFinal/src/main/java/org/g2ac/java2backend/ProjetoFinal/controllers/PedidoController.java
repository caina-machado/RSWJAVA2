package org.g2ac.java2backend.ProjetoFinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.java2backend.ProjetoFinal.entities.Pedido;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidoService.getPedidos();
	}

	@GetMapping("/{id}")
	public Pedido getPedido(@PathVariable Integer id) throws IdInvalidoException {
		return pedidoService.getPedido(id);
	}

	@PostMapping
	public void insertPedido(@Valid @RequestBody Pedido pedido) {
		pedidoService.insertPedido(pedido);
	}
	
	@PutMapping("/{id}")
	public Pedido updatePedido(@Valid @PathVariable Integer id, @RequestBody Pedido newPedido) throws IdInvalidoException {
		return pedidoService.updatePedido(id, newPedido);
	}
	
	@DeleteMapping("/{id}")
	public void deletePedido(@Valid @PathVariable Integer id) throws IdInvalidoException {
		pedidoService.deletePedido(id);
	}
}
