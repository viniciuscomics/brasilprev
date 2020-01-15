package br.com.app.brasilprev.service;

import java.util.List;
import java.util.Optional;

import br.com.app.brasilprev.model.Produto;

public interface ProdutoService {

	public Produto criar(Produto produto);
	public Optional<Produto> buscar(Long id);
	public List<Produto> listarTodas();
	public Produto alterar(Long id, Produto produto);
}
