package org.g2ac.java2backend.ProjetoFinal.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date dataFabricacao;
	
	@NotNull
	@Column(name = "valorUnidade", nullable = false)
	private Double valorUnidade;
	
	@NotNull
	@Column(name = "quantidadeEstoque", nullable = false)
	private Integer quantidadeEstoque;
	
	@Column(name = "descricao", length = 150)
	private String descricao;
	
	@NotNull
	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuarioVendedor;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "id_categoria", referencedColumnName = "id")
	private Categoria categoria;
	
	public Integer getIdProduto() {
		return id;
	}
	
	public void setIdProduto(Integer id) {
		this.id = id;
	}
	
	public Date getDataFabricacao() {
		return dataFabricacao;
	}
	
	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	
	public Double getValorUnidade() {
		return valorUnidade;
	}
	
	public void setValorUnidade(Double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}
	
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Usuario getUsuarioVendedor() {
		return usuarioVendedor;
	}
	
	public void setUsuarioVendedor(Usuario usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}