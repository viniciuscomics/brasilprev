package br.com.app.brasilprev.resource.impl;

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
import br.com.app.brasilprev.model.PedidoItens;
import br.com.app.brasilprev.resource.PedidoItensResource;
import br.com.app.brasilprev.service.PedidosItensService;
import br.com.app.brasilprev.utils.Utils;

@RestController
@RequestMapping("/pedidositens")
public class PedidoItensResourceImpl implements PedidoItensResource{
	
	@Autowired
	private PedidosItensService pedidosItensService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{id}")	
	public ResponseEntity<?> buscarItemPedido(@PathVariable Long id) {			
		return Utils.montarResponseEntity(pedidosItensService.buscar(id));
	}
	
	@PostMapping	
	public ResponseEntity<?> create(@Valid @RequestBody PedidoItens pedidoItens, HttpServletResponse response) {
		
		PedidoItens pedItem = pedidosItensService.criar(pedidoItens);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pedItem.getIdItem()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pedItem);		
	}

}
