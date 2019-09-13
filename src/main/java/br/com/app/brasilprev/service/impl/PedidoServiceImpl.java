package br.com.app.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Pedido;
import br.com.app.brasilprev.repository.PedidoRepository;
import br.com.app.brasilprev.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Override
	public Pedido criar(Pedido pedido) {		
		return pedidoRepository.save(pedido);
	}

	@Override
	public Optional<Pedido> buscar(Long id) {		
		return pedidoRepository.findById(id);
	}

	@Override
	public List<Pedido> listarTodas() {		
		return pedidoRepository.findAll();
	}
	
}
