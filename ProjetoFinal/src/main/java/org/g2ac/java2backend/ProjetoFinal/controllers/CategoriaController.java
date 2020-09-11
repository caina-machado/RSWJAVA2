package org.g2ac.java2backend.ProjetoFinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.java2backend.ProjetoFinal.entities.Categoria;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.services.CategoriaService;
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
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getCategorias() {
		return categoriaService.getCategorias();
	}
	
	@GetMapping("/{id}")
	public Categoria getCategoria(@PathVariable Integer id) throws IdInvalidoException {
		return categoriaService.getCategoria(id);
	}
	
	@PostMapping
	public void insertCategoria(@Valid @RequestBody Categoria categoria) {
		categoriaService.insertCategoria(categoria);
	}
	
	@PutMapping("/{id}")
	public Categoria updateCategoria(@Valid @PathVariable Integer id, @RequestBody Categoria newCategoria) throws IdInvalidoException {
		return categoriaService.updateCategoria(id, newCategoria);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCategoria(@Valid @PathVariable Integer id) throws IdInvalidoException {
		categoriaService.deleteCategoria(id);
	}
}
