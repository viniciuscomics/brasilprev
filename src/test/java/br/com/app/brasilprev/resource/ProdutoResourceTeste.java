package br.com.app.brasilprev.resource;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.app.brasilprev.UtilsTest;
import br.com.app.brasilprev.model.Categoria;
import br.com.app.brasilprev.model.Produto;
import br.com.app.brasilprev.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProdutoResourceTeste {

	final String BASE_PATH = "http://localhost:8080/produtos";

	private RestTemplate restTemplate;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Before
	public void setUp() throws Exception {
		restTemplate = new RestTemplate(UtilsTest.getClientHttpRequestFactory());
		produtoRepository.deleteAll();
	}
	
	@Test
	public void testCreate() throws JsonProcessingException {

		Produto response = cadastrar();
		Assert.assertNotNull(response);
		Assert.assertEquals("Arroz 5Kg", response.getDescricao());

	}

	private Categoria cadastrarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setCategoria("Grãos");
		return restTemplate.postForObject("http://localhost:8080/categorias", categoria, Categoria.class);
	}
	
	private Produto cadastrar() {
		Produto produto = new Produto();
		
		produto.setDescricao("Arroz 5Kg");
		produto.setIdProduto(123l);
		produto.setPreco(new BigDecimal(10.00));
		produto.setProduto("Tipo 1");
		produto.setQuantidade(10);
		produto.setCategoria(cadastrarCategoria());

		return restTemplate.postForObject(BASE_PATH, produto, Produto.class);
	}

	@Test
	public void testFindById() {

		Produto produto = cadastrar();
		ResponseEntity<Produto> response = restTemplate.getForEntity(BASE_PATH + "/" + produto.getIdProduto(),
				Produto.class);
		Assert.assertNotNull(response.getBody());

		Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);
		Assert.assertEquals(produto.getIdProduto(), response.getBody().getIdProduto());

	}

}
