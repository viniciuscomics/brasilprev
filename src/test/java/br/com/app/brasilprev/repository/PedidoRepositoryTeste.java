package br.com.app.brasilprev.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.model.Pedido;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrasilPrevApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoRepositoryTeste {	
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepo;	
	
	@Test
	public void testCreate() throws JsonProcessingException {

		Pedido pedido = cadastrar();
		Assert.assertNotNull(pedido);
		Assert.assertEquals("123", pedido.getSessao());		
		Assert.assertNotNull(pedido.getIdPedido());

	}

	private Pedido cadastrar() {
		Pedido pedido = new Pedido();
		
		pedido.setCliente(clienteRepository.getOne(1l));
		pedido.setData(LocalDate.now());
		pedido.setSessao("123");
		pedido.setStatus("ativo");	
		
		return pedidoRepo.save(pedido);
	}

	@Test
	public void testFindById() {

		Pedido pedido = cadastrar();
		Assert.assertNotNull(pedido);
		Assert.assertNotNull(pedido.getIdPedido());		
		
		assertEquals(pedido.getIdPedido(), pedidoRepo.getOne(pedido.getIdPedido()).getIdPedido());
	}
	
	@Test
	public void testAlterar() {
		
		Pedido pedido = cadastrar();
		Assert.assertNotNull(pedido);		
		
		pedido.setSessao("abc");		
		
		pedido = pedidoRepo.save(pedido);	
		
		Assert.assertNotNull(pedido);
		
		assertEquals("abc", pedido.getSessao());
		
	}

}
