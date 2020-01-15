package br.com.app.brasilprev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.brasilprev.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	public Optional<Users> findByEmail(String email);
}
