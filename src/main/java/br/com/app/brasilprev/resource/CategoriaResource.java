package br.com.app.brasilprev.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.app.brasilprev.exceptionhandler.SistemaExceptionHandler.Erro;
import br.com.app.brasilprev.model.Categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "Realiza cadastro e busca de categoria", tags = "Categorias",
authorizations = {@Authorization(value="basicAuth")})
public interface CategoriaResource {
	
	@ApiOperation(value = "Cadastrar uma nova categoria", code = 201,response = Categoria.class, notes = "Essa operação salva uma nova categoria.")			
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna um ResponseEntity<Categoria> com objeto criado", response = Categoria.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})	
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response);
	
	@ApiOperation(value ="Lista todas as categorias cadastradas", response = Categoria.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Categoria> listar();
	
	@ApiOperation(value ="Faz a busca de uma categoria pelo id.", response = Categoria.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable Long id);

}
