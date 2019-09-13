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
import br.com.app.brasilprev.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "Realiza cadastro e busca de clientes", tags = "Clientes",
authorizations = {@Authorization(value="basicAuth")})
public interface ClienteResource {
	
	@ApiOperation(value ="Lista todos os clientes cadastrados", response = Cliente.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Cliente> listar();
		
	@ApiOperation(value ="Faz a busca de um cliente pelo id.", response = Cliente.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> buscarCliente(@PathVariable Long id);
	
	
	@ApiOperation(value = "Cadastra um novo cliente",response = Cliente.class,
			notes = "Essa operação salva um novo cliente.", nickname = "cadastrar")			
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna um ResponseEntity<Cliente> com objeto criado", response = Cliente.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})	
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Cliente> cadastrar(@Valid @RequestBody Cliente cliente, HttpServletResponse response);
	
	@ApiOperation(value = "Atualiza um cliente",response = Cliente.class,
			notes = "Essa operação atualiza um cliente.", nickname = "atualizar")			
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna um ResponseEntity<Cliente> com objeto atualizado", response = Cliente.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente);
}
