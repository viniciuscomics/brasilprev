package br.com.app.brasilprev.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoRepositoryTeste {	
	
	@Autowired
	private ProdutoRepository produtoRepository;	
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	
	@Test
	public void testCreate() throws JsonProcessingException {

		Produto produto = produtoRepository.save(createProd(123l));
		Assert.assertNotNull(produto);
		Assert.assertNotNull(produto.getIdProduto());
		Assert.assertEquals("Arroz 5Kg", produto.getDescricao());
	}	
	
	private Produto createProd(Long id) {
		Produto produto = new Produto();
		
		produto.setDescricao("Arroz 5Kg");
		produto.setIdProduto(id);
		produto.setPreco(new BigDecimal(10.00));
		produto.setProduto("Tipo 1");
		produto.setQuantidade(10);
		
		Categoria categoria = new Categoria();
		categoria.setCategoria("Grãos");
		
		produto.setCategoria(categoriaRepo.save(categoria));

		return produto;
	}

	@Test
	public void testFindById() {

		Produto produto = produtoRepository.save(createProd(124l));	
		
		Assert.assertNotNull(produto);	
		
		Assert.assertNotNull(produto.getIdProduto());	

		assertEquals(produto.getIdProduto(), produtoRepository.getOne(produto.getIdProduto()).getIdProduto());	

	}

}
