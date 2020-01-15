package br.com.app.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Categoria;
import br.com.app.brasilprev.repository.CategoriaRepository;
import br.com.app.brasilprev.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	private CategoriaRepository categoriaRepository;	
	
	@Autowired
	public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public Categoria criar(Categoria categoria) {		
		return categoriaRepository.save(categoria);		
	}

	@Override
	public Optional<Categoria> buscar(Long id) {		
		return categoriaRepository.findById(id);		
	}

	@Override
	public List<Categoria> listarTodas() {		
		return categoriaRepository.findAll();
	}

}
