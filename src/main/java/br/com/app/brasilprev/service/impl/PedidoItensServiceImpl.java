package br.com.app.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.PedidoItens;
import br.com.app.brasilprev.repository.PedidoItensRepository;
import br.com.app.brasilprev.service.PedidosItensService;

@Service
public class PedidoItensServiceImpl implements PedidosItensService{

	@Autowired
	PedidoItensRepository pedidoItensRepository;
	
	@Override
	public PedidoItens criar(PedidoItens pedidoItens) {	
		return pedidoItensRepository.save(pedidoItens);
	}

	@Override
	public Optional<PedidoItens> buscar(Long id) {
		return pedidoItensRepository.findById(id);
	}

	@Override
	public List<PedidoItens> listarTodas() {		
		return pedidoItensRepository.findAll();
	}
	
}
