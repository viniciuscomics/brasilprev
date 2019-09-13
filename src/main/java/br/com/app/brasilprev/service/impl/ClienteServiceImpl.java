package br.com.app.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.exception.ClienteInexistenteException;
import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.repository.ClienteRepository;
import br.com.app.brasilprev.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public Cliente criar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	public Optional<Cliente> buscar(Long id) {		
		return clienteRepository.findById(id);
	}

	@Override
	public List<Cliente> listarTodos() {
		
		return clienteRepository.findAll();
	}
	
	@Override
	public Cliente alterar(Long id,Cliente cliente) {
		
		Optional<Cliente> optCliente = clienteRepository.findById(id);
		
		if(optCliente.get() == null) {
			throw new ClienteInexistenteException();
		}
		
		Cliente clienteSalvo = optCliente.get();
		
		BeanUtils.copyProperties(cliente, clienteSalvo, "idCliente");		
		
		return clienteRepository.save(clienteSalvo);
	}

}
