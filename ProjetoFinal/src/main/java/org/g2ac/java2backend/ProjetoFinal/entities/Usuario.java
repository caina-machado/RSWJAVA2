package org.g2ac.java2backend.ProjetoFinal.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "cpf", nullable = false, unique = true, length = 11)
	private String cpf;
	
	@NotNull
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotNull
	@Column(name = "nomeUsuario", nullable = false, unique = true, length = 15)
	private String nomeUsuario;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Past
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Sao_Paulo")
	private Date dataNascimento;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco", referencedColumnName = "id")
	private Endereco endereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contato", referencedColumnName = "id")
	private Contato contato;
	
	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Integer getIdUsuario() {
		return id;
	}
	
	public void setIdUsuario(Integer id) {
		this.id= id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}