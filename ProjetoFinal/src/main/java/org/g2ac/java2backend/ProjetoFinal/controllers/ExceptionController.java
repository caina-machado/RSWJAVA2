package org.g2ac.java2backend.ProjetoFinal.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException exception) {
		Map <String, String> errosOcorridos = new HashMap<>();
		List<ObjectError> erros = exception.getBindingResult().getAllErrors();
		for(ObjectError erro : erros) {
			String atributo = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			errosOcorridos.put(atributo, mensagem);
		}
		return errosOcorridos;
	}
	
	@ExceptionHandler(IdInvalidoException.class)
	public ResponseEntity<String> trataIdInvalido(IdInvalidoException exception) {
		String msg = String.format("O ID digitado (%d) é inválido", exception.getId());
		return ResponseEntity.notFound()
				.header("x-erro-msg", msg)
				.header("x-erro-code", "ID_INVALIDO")
				.header("x-erro-values", "" + exception.getId())
				.build();
	}
}