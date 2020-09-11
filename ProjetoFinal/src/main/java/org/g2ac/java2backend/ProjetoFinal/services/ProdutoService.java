package org.g2ac.java2backend.ProjetoFinal.services;

import java.util.List;

import org.g2ac.java2backend.ProjetoFinal.entities.Produto;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
	public Produto getProduto(Integer id) throws IdInvalidoException {
		if(produtoRepository.existsById(id)) {
			return produtoRepository.findById(id).get();
		}
		throw new IdInvalidoException(id);
	}
	
	@Transactional
	public void insertProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	@Transactional
	public Produto updateProduto(Integer id, Produto newProduto) throws IdInvalidoException {
		Produto produtoEncontrado = getProduto(id);
		produtoEncontrado.setDataFabricacao(newProduto.getDataFabricacao());
		produtoEncontrado.setValorUnidade(newProduto.getValorUnidade());
		produtoEncontrado.setQuantidadeEstoque(newProduto.getQuantidadeEstoque());
		produtoEncontrado.setDescricao(newProduto.getDescricao());
		produtoEncontrado.setNome(newProduto.getNome());
		produtoEncontrado.setUsuarioVendedor(newProduto.getUsuarioVendedor());
		produtoEncontrado.setCategoria(newProduto.getCategoria());
		return produtoEncontrado;
	}
	
	@Transactional
	public void deleteProduto(Integer id) throws IdInvalidoException {
		produtoRepository.delete(getProduto(id));
	}
}
