package org.g2ac.java2backend.ProjetoFinal.controllers;

import java.util.List;

import javax.validation.Valid;

import org.g2ac.java2backend.ProjetoFinal.entities.Produto;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.services.ProdutoService;
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
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();
	}
	
	@GetMapping("/{id}")
	public Produto getProduto(@PathVariable Integer id) throws IdInvalidoException {
		return produtoService.getProduto(id);
	}
	
	@PostMapping
	public void insertProduto(@Valid @RequestBody Produto produto) {
		produtoService.insertProduto(produto);
	}
	
	@PutMapping("/{id}")
	public Produto updateProduto(@Valid @PathVariable Integer id, @RequestBody Produto newProduto) throws IdInvalidoException {
		return produtoService.updateProduto(id, newProduto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@Valid @PathVariable Integer id) throws IdInvalidoException {
		produtoService.deleteProduto(id);
	}
}
