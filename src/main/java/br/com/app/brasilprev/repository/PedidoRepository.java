package br.com.app.brasilprev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.brasilprev.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
