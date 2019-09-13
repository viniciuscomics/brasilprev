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
import br.com.app.brasilprev.model.Pedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "Realiza cadastro e busca de pedidos", tags = "Pedidos",
authorizations = {@Authorization(value="basicAuth")})
public interface PedidoResource {

	@ApiOperation(value ="Lista todos os pedidos cadastrados", response = Pedido.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Pedido> listar();	
	
	@ApiOperation(value ="Faz a busca de um pedido pelo id.", response = Pedido.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> buscarPedido(@PathVariable Long id);	
	
	@ApiOperation(value = "Cadastra um novo pedido",response = Pedido.class,
			notes = "Essa operação salva um novo pedido.", nickname = "create")			
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna um ResponseEntity<Pedido> com objeto criado", response = Pedido.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})	
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Pedido> create(@Valid @RequestBody Pedido pedido, HttpServletResponse response);	

}
