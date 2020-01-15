package br.com.app.brasilprev.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.model.Pedido;
import br.com.app.brasilprev.model.PedidoItens;

import br.com.app.brasilprev.repository.ClienteRepository;
import br.com.app.brasilprev.repository.PedidoRepository;
import br.com.app.brasilprev.repository.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrasilPrevApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PedidosItensTest {

	@Autowired
	private PedidosItensService pedidosItens;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	private PedidoItens createObjPedidoItens() {
		
		Pedido ped = new Pedido();
		PedidoItens pedItem = new PedidoItens();
		
		ped.setCliente(clienteRepository.getOne(1l));
		ped.setData(LocalDate.now());
		ped.setSessao("afg");
		ped.setStatus("aberto");		
		
		pedItem.setPedido(pedidoRepository.save(ped));
		pedItem.setProduto(produtoRepository.getOne(1l));
		pedItem.setQuantidade(1);
		pedItem.setSubtotal(new BigDecimal(2.00));
		pedItem.setValor(new BigDecimal(2.00));
		pedItem.setProd("abcd");
		
		return pedItem;
	}
	
	@Test
	public void createPedItens() {
		
		PedidoItens ped = createObjPedidoItens();
		
		assertNotNull(ped);
		
		ped = pedidosItens.criar(ped);
		
		assertNotNull(ped);
		
		assertNotNull(ped.getIdItem());		
		
	}
	
	@Test
	public void buscar() {
		
		PedidoItens ped = createObjPedidoItens();
		
		assertNotNull(ped);
		
		ped = pedidosItens.criar(ped);
		
		Optional<PedidoItens> opt = pedidosItens.buscar(ped.getIdItem());
		
		assertNotNull(opt.get());
		
		assertEquals(ped.getIdItem(), opt.get().getIdItem());
		
	}
	
}
