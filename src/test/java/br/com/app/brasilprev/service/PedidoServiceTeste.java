package br.com.app.brasilprev.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.model.Pedido;
import br.com.app.brasilprev.repository.ClienteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrasilPrevApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidoServiceTeste {

	@Autowired
	private PedidoService pedidoServ;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Test
	public void criar() {
		Pedido pedido = new Pedido();
		
		pedido.setCliente(clienteRepo.getOne(1l));
		pedido.setData(LocalDate.now());
		pedido.setSessao("123");
		pedido.setStatus("aberto");	
		
		pedido = pedidoServ.criar(pedido);
		
		assertNotNull(pedido);
		
		assertNotNull(pedido.getIdPedido());
	}
	
	@Test
	public void buscar() {
		
		Pedido pedido = new Pedido();
		
		pedido.setCliente(clienteRepo.getOne(1l));
		pedido.setData(LocalDate.now());
		pedido.setSessao("123");
		pedido.setStatus("aberto");	
		
		pedido = pedidoServ.criar(pedido);
		
		assertNotNull(pedido);
		
		assertNotNull(pedido.getIdPedido());
		
		Optional<Pedido> opt = pedidoServ.buscar(pedido.getIdPedido());
		
		assertNotNull(opt.get());
		
		assertEquals(pedido.getIdPedido(), opt.get().getIdPedido());
	}
	
}
