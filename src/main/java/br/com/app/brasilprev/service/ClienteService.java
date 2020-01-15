package br.com.app.brasilprev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Cliente;

@Service
public interface ClienteService {
	public Cliente criar(Cliente cliente);
	public Optional<Cliente> buscar(Long id);
	public List<Cliente> listarTodos();
	public Cliente alterar(Long id, Cliente cliente);
}
