package br.com.app.brasilprev.resource;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.UtilsTest;
import br.com.app.brasilprev.model.Categoria;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrasilPrevApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaResourceTeste {

	@LocalServerPort
	private int port;	
	
	private String BASE_PATH = "";

	private RestTemplate restTemplate;
	
	@Before
	public void setUp() throws Exception {
		
		BASE_PATH = "http://localhost:"+port+"/categorias";
		
		restTemplate = new RestTemplate(UtilsTest.getClientHttpRequestFactory());		
	}

	@Test
	public void testCreate() throws JsonProcessingException {

		Categoria response = cadastrar();
		Assert.assertNotNull(response);
		Assert.assertEquals("Horti-Frutti", response.getCategoria());

	}

	private Categoria cadastrar() {
		Categoria categoria = new Categoria();

		categoria.setCategoria("Horti-Frutti");

		return restTemplate.postForObject(BASE_PATH, categoria, Categoria.class);
	}

	@Test
	public void testFindById() {

		Categoria cat = cadastrar();
		ResponseEntity<Categoria> response = restTemplate.getForEntity(BASE_PATH + "/" + cat.getIdCategoria(),
				Categoria.class);
		Assert.assertNotNull(response.getBody());

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(cat.getIdCategoria(), response.getBody().getIdCategoria());

	}

	@Test
	public void buscarTodasCategorias() {

		List<Categoria> listCadastrado = new ArrayList<>();

		listCadastrado.add(cadastrar());
		listCadastrado.add(cadastrar());
		listCadastrado.add(cadastrar());

		ResponseEntity<List<Categoria>> response = restTemplate.exchange(BASE_PATH, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Categoria>>() {
				});

		Assert.assertNotNull(response.getBody());
		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);		
		
		for(Categoria categoria :listCadastrado ) {		
			Categoria encontrada = response.getBody().stream()
			.filter(c->c.getIdCategoria().equals(categoria.getIdCategoria())).findFirst().get();
			
			Assert.assertNotNull(encontrada);
		}

	}

}