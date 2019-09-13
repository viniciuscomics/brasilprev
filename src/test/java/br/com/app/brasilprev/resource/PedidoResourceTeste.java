package br.com.app.brasilprev.resource;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.app.brasilprev.UtilsTest;
import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.model.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PedidoResourceTeste {

	final String BASE_PATH = "http://localhost:8080/pedidos";

	private RestTemplate restTemplate;
		
	@Before
	public void setUp() throws Exception {
		restTemplate = new RestTemplate(UtilsTest.getClientHttpRequestFactory());		
	}
	
	@Test
	public void testCreate() throws JsonProcessingException {

		Pedido response = cadastrar();
		Assert.assertNotNull(response);
		Assert.assertEquals("123", response.getSessao());

	}
	
	private Cliente cadastrarClientes() {
		Cliente cliente = new Cliente();
		
		cliente.setBairro("Jabaquara");
		cliente.setCep("04321002");
		cliente.setCidade("São Paulo");
		cliente.setEmail("vinicius_csa@yahoo.com.br");
		cliente.setNome("Vinicius Costa");
		cliente.setEstado("São Paulo");
		cliente.setSenha("123456");
		cliente.setRua("Rua dos Buritis");

		return restTemplate.postForObject("http://localhost:8080/clientes", cliente, Cliente.class);
	}

	private Pedido cadastrar() {
		Pedido pedido = new Pedido();
		
		pedido.setCliente(cadastrarClientes());
		pedido.setData(LocalDate.now());
		pedido.setSessao("123");
		pedido.setStatus("ativo");		

		return restTemplate.postForObject(BASE_PATH, pedido, Pedido.class);
	}

	@Test
	public void testFindById() {

		Pedido pedido = cadastrar();
		ResponseEntity<Pedido> response = restTemplate.getForEntity(BASE_PATH + "/" + pedido.getIdPedido(),
				Pedido.class);
		Assert.assertNotNull(response.getBody());

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(pedido.getIdPedido(), response.getBody().getIdPedido());

	}

}
