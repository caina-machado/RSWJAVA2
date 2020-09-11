package org.g2ac.java2backend.ProjetoFinal.services;

import java.util.List;

import org.g2ac.java2backend.ProjetoFinal.entities.Categoria;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}
	
	public Categoria getCategoria(Integer id) throws IdInvalidoException {
		if(categoriaRepository.existsById(id)) {
			return categoriaRepository.findById(id).get();
		}
		throw new IdInvalidoException(id);
	}
	
	@Transactional
	public void insertCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	@Transactional
	public Categoria updateCategoria(Integer id, Categoria newCategoria) throws IdInvalidoException {
		Categoria categoriaEncontrada = getCategoria(id);
		categoriaEncontrada.setNome(newCategoria.getNome());
		categoriaEncontrada.setDescricao(newCategoria.getDescricao());
		return categoriaEncontrada;
	}
	
	@Transactional
	public void deleteCategoria(Integer id) throws IdInvalidoException {
		categoriaRepository.delete(getCategoria(id));
	}
}
