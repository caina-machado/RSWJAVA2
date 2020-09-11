package org.g2ac.java2backend.ProjetoFinal.services;

import java.util.Date;
import java.util.List;

import org.g2ac.java2backend.ProjetoFinal.entities.Pedido;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}
	
	public Pedido getPedido(Integer id) throws IdInvalidoException {
		if(pedidoRepository.existsById(id)) {
			return pedidoRepository.findById(id).get();
		}
		throw new IdInvalidoException(id);
	}
	
	@Transactional
	public void insertPedido(Pedido pedido) {
		pedido.setDataRealizado(new Date());
		pedidoRepository.save(pedido);
	}
	
	@Transactional
	public Pedido updatePedido(Integer id, Pedido newPedido) throws IdInvalidoException {
		Pedido pedidoEncontrado = getPedido(id);
		pedidoEncontrado.setListaPedidosItem(newPedido.getListaPedidosItem());
		pedidoEncontrado.setUsuarioComprador(newPedido.getUsuarioComprador());
		return pedidoEncontrado;
	}
	
	@Transactional
	public void deletePedido(Integer id) throws IdInvalidoException {
		pedidoRepository.delete(getPedido(id));
	}
}
