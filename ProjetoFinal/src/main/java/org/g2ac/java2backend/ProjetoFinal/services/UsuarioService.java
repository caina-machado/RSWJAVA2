package org.g2ac.java2backend.ProjetoFinal.services;

import java.util.List;

import org.g2ac.java2backend.ProjetoFinal.entities.Usuario;
import org.g2ac.java2backend.ProjetoFinal.exceptions.IdInvalidoException;
import org.g2ac.java2backend.ProjetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}
	
	public Usuario getUsuario(Integer id) throws IdInvalidoException {
		if(usuarioRepository.existsById(id)) {
			return usuarioRepository.findById(id).get();
		}
		throw new IdInvalidoException(id);
	}
	
	@Transactional
	public void insertUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	@Transactional
	public Usuario updateUsuario(Integer id, Usuario newUsuario) throws IdInvalidoException {
		Usuario usuarioEncontrado = getUsuario(id);
		usuarioEncontrado.setNome(newUsuario.getNome());
		usuarioEncontrado.setCpf(newUsuario.getCpf());
		usuarioEncontrado.setEmail(newUsuario.getEmail());
		usuarioEncontrado.setNomeUsuario(newUsuario.getNomeUsuario());
		usuarioEncontrado.setDataNascimento(newUsuario.getDataNascimento());
		usuarioEncontrado.getEndereco().setRua(newUsuario.getEndereco().getRua());
		usuarioEncontrado.getEndereco().setNumero(newUsuario.getEndereco().getNumero());
		usuarioEncontrado.getEndereco().setBairro(newUsuario.getEndereco().getBairro());
		usuarioEncontrado.getEndereco().setCidade(newUsuario.getEndereco().getCidade());
		usuarioEncontrado.getEndereco().setEstado(newUsuario.getEndereco().getEstado());
		usuarioEncontrado.getEndereco().setCep(newUsuario.getEndereco().getCep());
		usuarioEncontrado.getContato().setDdd(newUsuario.getContato().getDdd());
		usuarioEncontrado.getContato().setFixo(newUsuario.getContato().getFixo());
		usuarioEncontrado.getContato().setMovel(newUsuario.getContato().getMovel());
		return usuarioRepository.save(usuarioEncontrado);
	}
	
	@Transactional
	public void deleteUsuario(Integer id) throws IdInvalidoException {
			Usuario usuarioApagado = getUsuario(id);
			usuarioRepository.delete(usuarioApagado);
	}
}
