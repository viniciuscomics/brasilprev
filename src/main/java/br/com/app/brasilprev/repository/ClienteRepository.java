package br.com.app.brasilprev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.brasilprev.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{	
}
