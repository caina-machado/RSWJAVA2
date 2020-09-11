package org.g2ac.java2backend.ProjetoFinal.exceptions;

public class IdInvalidoException extends Exception {

	private Integer id;

	public IdInvalidoException(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
