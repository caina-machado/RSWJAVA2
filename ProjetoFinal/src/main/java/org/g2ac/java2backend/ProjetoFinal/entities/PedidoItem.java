package org.g2ac.java2backend.ProjetoFinal.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PedidoItem")
public class PedidoItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "quantidadeItem", nullable = false)
	private Integer quantidadeItem;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_produto", referencedColumnName = "id")
	private Produto produto;
	
//	@NotNull
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_pedido", referencedColumnName = "id")
//	private Pedido pedido;
	
	public Integer getIdItemPedido() {
		return id;
	}
	
	public void setIdItemPedido(Integer id) {
		this.id = id;
	}
	
	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}
	
	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
//	public Pedido getPedido() {
//		return pedido;
//	}
//	
//	public void setPedido(Pedido pedido) {
//		this.pedido = pedido;
//	}
}
