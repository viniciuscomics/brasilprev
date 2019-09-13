package br.com.app.brasilprev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.brasilprev.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	public Optional<Cliente> findByEmail(String email);
}
