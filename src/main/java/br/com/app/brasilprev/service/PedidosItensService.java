package br.com.app.brasilprev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.PedidoItens;

@Service
public interface PedidosItensService {	
	public PedidoItens criar(PedidoItens pedidoItens);
	public Optional<PedidoItens> buscar(Long id);
	public List<PedidoItens> listarTodas();
}
