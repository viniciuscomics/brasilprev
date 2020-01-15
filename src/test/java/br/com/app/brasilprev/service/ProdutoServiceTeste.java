package br.com.app.brasilprev.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.model.Categoria;
import br.com.app.brasilprev.model.Produto;
import br.com.app.brasilprev.repository.CategoriaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BrasilPrevApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoServiceTeste {

	@Autowired
	private ProdutoService produtoServ;

	@Autowired
	private CategoriaRepository categoriaRepo;

	@Test
	public void listarTodos() {

		List<Produto> listProd = produtoServ.listarTodas();

		assertNotNull(listProd);

		assertEquals(1,listProd.size());

	}
	
	@Test
	public void buscar() {

		Optional<Produto> prod = produtoServ.buscar(1l);

		assertNotNull(prod.get());

		assertNotNull(prod.get().getIdProduto());

	}
	
	@Test
	public void buscaErro() {

		Optional<Produto> prod = produtoServ.buscar(45l);

		assertEquals(null,prod.get());

	}

	@Test
	public void Criar() {

		Produto produto = new Produto();

		produto.setDescricao("Açucar 1Kg");
		produto.setIdProduto(12l);
		produto.setPreco(new BigDecimal(3.00));
		produto.setProduto("Refinado");
		produto.setQuantidade(10);

		Categoria categoria = new Categoria();
		categoria.setCategoria("Alimentos");

		produto.setCategoria(categoriaRepo.save(categoria));

		produto = produtoServ.criar(produto);

		assertNotNull(produto);

		assertNotNull(produto.getIdProduto());

	}
	
	@Test
	public void alterar() {

		Optional<Produto> opt = produtoServ.buscar(1l);

		assertNotNull(opt.get());

		assertNotNull(opt.get().getIdProduto());
		
		Produto produto = opt.get();
		
		produto.setProduto("cristal");
		
		produto = produtoServ.alterar(produto.getIdProduto(), produto);
		
		assertNotNull(produto);
		
		assertEquals("cristal", produto.getProduto());

	}

}
