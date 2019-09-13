package br.com.app.brasilprev.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.app.brasilprev.exceptionhandler.SistemaExceptionHandler.Erro;
import br.com.app.brasilprev.model.PedidoItens;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "Realiza cadastro e busca de pedidosItens", tags = "PedidosItens",
authorizations = {@Authorization(value="basicAuth")})
public interface PedidoItensResource {

	@ApiOperation(value ="Faz a busca de um pedido itens pelo id.", response = PedidoItens.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> buscarItemPedido(@PathVariable Long id);	
	
	@ApiOperation(value = "Cadastra um novo pedidoItens",response = PedidoItens.class,
			notes = "Essa operação salva um novo pedidoItens.", nickname = "create")			
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna um ResponseEntity<PedidoItens> com objeto criado", response = PedidoItens.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})	
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody PedidoItens pedidoItens, HttpServletResponse response);
}
