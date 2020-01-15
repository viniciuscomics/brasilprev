package br.com.app.brasilprev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.app.brasilprev.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
