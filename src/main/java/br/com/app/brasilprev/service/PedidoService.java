package br.com.app.brasilprev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Pedido;

@Service
public interface PedidoService {
	
	public Pedido criar(Pedido pedido);
	public Optional<Pedido> buscar(Long id);
	public List<Pedido> listarTodas();	

}
