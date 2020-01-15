package br.com.app.brasilprev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Categoria;

@Service
public interface CategoriaService {

	public Categoria criar(Categoria categoria);
	public Optional<Categoria> buscar(Long id);
	public List<Categoria> listarTodas();
}
