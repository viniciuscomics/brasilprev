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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.brasilprev.event.RecursoCriadoEvent;
import br.com.app.brasilprev.model.Pedido;
import br.com.app.brasilprev.resource.PedidoResource;
import br.com.app.brasilprev.service.PedidoService;
import br.com.app.brasilprev.utils.Utils;

@RestController
@RequestMapping("/pedidos")
public class PedidoResourceImpl implements PedidoResource{
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Pedido> listar(){
		return pedidoService.listarTodas();
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<?> buscarPedido(@PathVariable Long id) {			
		return Utils.montarResponseEntity(pedidoService.buscar(id));
	}	
	
	@PostMapping	
	public ResponseEntity<Pedido> create(@Valid @RequestBody Pedido pedido, HttpServletResponse response) {
		
		Pedido ped = pedidoService.criar(pedido);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, ped.getIdPedido()));
		return ResponseEntity.status(HttpStatus.CREATED).body(ped);		
	}

}
