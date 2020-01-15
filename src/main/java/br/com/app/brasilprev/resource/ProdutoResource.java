package br.com.app.brasilprev.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.app.brasilprev.exceptionhandler.SistemaExceptionHandler.Erro;
import br.com.app.brasilprev.model.Produto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;

@Api(description = "Realiza cadastro, busca e atualização de produtos", tags = "Produtos",
	authorizations = {@Authorization(value="basicAuth")})
public interface ProdutoResource {
	
	@ApiOperation(value ="Faz a busca de um produto pelo id.", response = Produto.class,
			code=200)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> buscarProduto(@PathVariable Long id);	
	
	
	@ApiOperation(value = "Cadastra um novo produto",response = Produto.class,
			notes = "Essa operação salva um novo produto.", nickname = "create")			
	@ApiResponses(value = {
	@ApiResponse(code = 201, message = "Retorna um ResponseEntity<Produto> com objeto criado", response = Produto.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Produto> create(@ApiParam(allowableValues = "categoria") @Valid @RequestBody Produto produto, HttpServletResponse response);	
	
	
	@ApiOperation(value = "Atualiza um produto",response = Produto.class,
			notes = "Essa operação atualiza um produto.", nickname = "atualizar")			
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "Retorna um ResponseEntity<Produto> com objeto atualizado", response = Produto.class),
	@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseEntity com a mensagem de erro", response = Erro.class)
	})
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<?> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto);

}
