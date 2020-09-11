package org.g2ac.java2backend.ProjetoFinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.java2backend.ProjetoFinal.entities.Usuario;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.services.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuario(@PathVariable Integer id) throws IdInvalidoException {
		return usuarioService.getUsuario(id);
	}
	
	@PostMapping
	public void insertUsuario(@Valid @RequestBody Usuario usuario) {
		usuarioService.insertUsuario(usuario);
	}
	
	@PutMapping("/{id}")
	public Usuario updateUsuario(@Valid @PathVariable Integer id, @RequestBody Usuario newUsuario) throws IdInvalidoException {
		return usuarioService.updateUsuario(id, newUsuario);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@Valid @PathVariable Integer id) throws IdInvalidoException {
		usuarioService.deleteUsuario(id);
	}
}
