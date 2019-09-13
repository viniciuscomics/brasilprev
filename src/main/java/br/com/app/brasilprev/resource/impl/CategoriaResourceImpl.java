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
import br.com.app.brasilprev.model.Categoria;
import br.com.app.brasilprev.resource.CategoriaResource;
import br.com.app.brasilprev.service.CategoriaService;
import br.com.app.brasilprev.utils.Utils;

@RestController
@RequestMapping("/categorias")
public class CategoriaResourceImpl implements CategoriaResource{

	@Autowired
	CategoriaService categoriaService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {

		Categoria cat = categoriaService.criar(categoria);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, cat.getIdCategoria()));
		return ResponseEntity.status(HttpStatus.CREATED).body(cat);
	}

	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaService.listarTodas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long id) {
		return Utils.montarResponseEntity(categoriaService.buscar(id));
	}

}
