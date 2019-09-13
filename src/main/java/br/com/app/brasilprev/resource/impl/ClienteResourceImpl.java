package br.com.app.brasilprev.resource.impl;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.brasilprev.event.RecursoCriadoEvent;
import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.resource.ClienteResource;
import br.com.app.brasilprev.service.ClienteService;
import br.com.app.brasilprev.utils.Utils;

@RestController
@RequestMapping("/clientes")
public class ClienteResourceImpl implements ClienteResource{
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping	
	public List<Cliente> listar() {
		return clienteService.listarTodos();
	}

	@GetMapping("/{id}")	
	public ResponseEntity<?> buscarCliente(@PathVariable Long id) {		
		return Utils.montarResponseEntity(clienteService.buscar(id));
	}

	@PostMapping	
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente, HttpServletResponse response) {

		Cliente cli = clienteService.criar(cliente);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, cli.getIdCliente()));

		return ResponseEntity.status(HttpStatus.CREATED).body(cli);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(Long id, @Valid Cliente cliente) {
		Cliente cli = clienteService.alterar(id, cliente);
		
		return cli != null ? ResponseEntity.ok(cli) : ResponseEntity.notFound().build();
	}	
	
}
