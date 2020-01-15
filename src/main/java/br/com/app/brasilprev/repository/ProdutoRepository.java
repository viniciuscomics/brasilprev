package br.com.app.brasilprev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.app.brasilprev.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
