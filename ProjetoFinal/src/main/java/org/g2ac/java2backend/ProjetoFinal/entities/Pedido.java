package org.g2ac.java2backend.ProjetoFinal.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Sao_Paulo") 
	private Date dataRealizado;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuarioComprador;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pedido")
	private Set<PedidoItem> listaPedidosItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRealizado() {
		return dataRealizado;
	}

	public void setDataRealizado(Date dataRealizado) {
		this.dataRealizado = dataRealizado;
	}

	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}

	public void setUsuarioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}

	public Set<PedidoItem> getListaPedidosItem() {
		return listaPedidosItem;
	}

	public void setListaPedidosItem(Set<PedidoItem> listaPedidosItem) {
		this.listaPedidosItem = listaPedidosItem;
	}
}