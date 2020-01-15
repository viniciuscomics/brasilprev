package br.com.app.brasilprev.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.app.brasilprev.UtilsTest;
import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteResourceTeste {

	@LocalServerPort
	private int port;
	
	private String BASE_PATH = "";

	private RestTemplate restTemplate;
	
	@Autowired
	ClienteRepository clienteRepository;

	@Before
	public void setUp() throws Exception {
		BASE_PATH = "http://localhost:"+port+"/clientes";
		restTemplate = new RestTemplate(UtilsTest.getClientHttpRequestFactory());		
	}
	
	@Test
	public void testCreate() throws JsonProcessingException {

		Cliente response = cadastrar();
		Assert.assertNotNull(response);
		Assert.assertEquals("Vinicius Costa", response.getNome());

	}

	private Cliente cadastrar() {
		Cliente cliente = new Cliente();
		
		cliente.setBairro("Jabaquara");
		cliente.setCep("04321002");
		cliente.setCidade("São Paulo");
		cliente.setEmail("vinicius_csa@yahoo.com.br");
		cliente.setNome("Vinicius Costa");
		cliente.setEstado("São Paulo");
		cliente.setSenha("123456");
		cliente.setRua("Rua dos Buritis");

		return restTemplate.postForObject(BASE_PATH, cliente, Cliente.class);
	}

	@Test
	public void testFindById() {

		Cliente cliente = cadastrar();
		ResponseEntity<Cliente> response = restTemplate.getForEntity(BASE_PATH + "/" + cliente.getIdCliente(),
				Cliente.class);
		Assert.assertNotNull(response.getBody());

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(cliente.getIdCliente(), response.getBody().getIdCliente());

	}
	
	@Test
	public void alterar() {
		Cliente cliente = cadastrar();
		
		Assert.assertNotNull(cliente);
		
		cliente.setNome("Gustavo Pires Costa");		
			    
	    		
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", cliente.getIdCliente().toString());
	    
		restTemplate.put(BASE_PATH+ "/{id}" ,cliente ,params);	
		
		ResponseEntity<Cliente> response = restTemplate.getForEntity(BASE_PATH + "/" + cliente.getIdCliente(),
				Cliente.class);
		
		Assert.assertNotNull(response.getBody());

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals("Gustavo Pires Costa", response.getBody().getNome());
	}

	@Test
	public void buscarLista() {

		List<Cliente> listCadastrado = new ArrayList<>();

		listCadastrado.add(cadastrar());
		listCadastrado.add(cadastrar());
		listCadastrado.add(cadastrar());

		ResponseEntity<List<Cliente>> response = restTemplate.exchange(BASE_PATH, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cliente>>() {
				});

		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		for(Cliente cliente : listCadastrado) {		
			Cliente encontrado = response.getBody().stream()
			.filter(c->c.getIdCliente().equals(cliente.getIdCliente())).findFirst().get();
			
			Assert.assertNotNull(encontrado);
		}

	}
	
}
