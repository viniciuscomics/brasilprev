package br.com.app.brasilprev.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.app.brasilprev.BrasilPrevApplication;
import br.com.app.brasilprev.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BrasilPrevApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteServiceTeste {

	
	@Autowired
	private ClienteService clienteServ;	
	
	@Test
	public void listarTodos() {
		
		List<Cliente> listCliente = clienteServ.listarTodos();
		
		assertNotNull(listCliente);
		
		assertTrue(listCliente.size()>0);		
	}
	
	@Test
	public void buscar() {
		
		Optional<Cliente> cliente = clienteServ.buscar(1l);
		
		assertNotNull(cliente.get());
		
		assertNotNull(cliente.get().getIdCliente());		
		
	}
	
	@Test
	public void buscaErro() {
		
		Optional<Cliente> cliente = clienteServ.buscar(50l);
		
		assertFalse(cliente.isPresent());		
	}
	
	@Test
	public void testCreate() {
		
		Cliente cliente = new Cliente();
		
		cliente.setBairro("Jd Teste");
		cliente.setCep("01111111");
		cliente.setCidade("Teste");
		cliente.setEmail("teste1@teste.com.br");
		cliente.setEstado("Sao Paulo");
		cliente.setNome("Vinicius");
		cliente.setRua("Rua Teste");
		cliente.setSenha("brasilprev2020");
		
		cliente = clienteServ.criar(cliente);
		
		assertNotNull(cliente);
		
		assertNotNull(cliente.getIdCliente());
		
	}
	
	@Test
	public void alterar() {
		
		Optional<Cliente> opt = clienteServ.buscar(1l);
		
		assertNotNull(opt.get());
		
		assertNotNull(opt.get().getIdCliente());
		
		Cliente cliente = opt.get();
		
		cliente.setNome("Alterado");
		
		cliente = clienteServ.alterar(cliente.getIdCliente(), cliente);
		
		assertNotNull(cliente);
		
		assertEquals("Alterado", cliente.getNome());
		
	}
	
	
	
}
