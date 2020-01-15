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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.brasilprev.event.RecursoCriadoEvent;
import br.com.app.brasilprev.model.Produto;
import br.com.app.brasilprev.resource.ProdutoResource;
import br.com.app.brasilprev.service.ProdutoService;
import br.com.app.brasilprev.utils.Utils;

@RestController
@RequestMapping("/produtos")
public class ProdutoResourceImpl implements ProdutoResource{
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping("/{id}")	
	public ResponseEntity<?> buscarProduto(@PathVariable Long id) {			
		return Utils.montarResponseEntity(produtoService.buscar(id));
	}
	
	@PostMapping	
	public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto, HttpServletResponse response) {
		
		Produto prod = produtoService.criar(produto);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, prod.getIdProduto()));
		return ResponseEntity.status(HttpStatus.CREATED).body(prod);		
	}
	
	@PutMapping("/{id}")	
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
		
		Produto prod = produtoService.alterar(id, produto);
		
		return prod != null ? ResponseEntity.ok(prod) : ResponseEntity.notFound().build();
	}

}
