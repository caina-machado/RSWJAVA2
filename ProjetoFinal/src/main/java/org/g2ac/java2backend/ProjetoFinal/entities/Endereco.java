package org.g2ac.java2backend.ProjetoFinal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "rua", nullable = false, length = 40)
	private String rua;
	
	@NotNull
	@Column(name = "numero", nullable = false, length = 15)
	private String numero;
	
	@NotNull
	@Column(name = "bairro", nullable = false, length = 30)
	private String bairro;
	
	@NotNull
	@Column(name = "cidade", nullable = false, length = 40)
	private String cidade;
	
	@NotNull
	@Column(name = "estado", nullable = false, length = 2)
	private String estado;
	
	@NotNull
	@Column(name = "cep", nullable = false, length = 9)
	private String cep;
	
	public Integer getIdEndereco() {
		return id;
	}
	
	public void setIdEndereco(Integer id) {
		this.id = id;
	}
	
	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
}