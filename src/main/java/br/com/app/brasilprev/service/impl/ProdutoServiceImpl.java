package br.com.app.brasilprev.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.exception.CategoriaInexistenteException;
import br.com.app.brasilprev.exception.ProdutoInexistenteException;
import br.com.app.brasilprev.model.Categoria;
import br.com.app.brasilprev.model.Produto;
import br.com.app.brasilprev.repository.CategoriaRepository;
import br.com.app.brasilprev.repository.ProdutoRepository;
import br.com.app.brasilprev.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService{
	
	private ProdutoRepository produtoRepository;	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	public ProdutoServiceImpl(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {		
		this.produtoRepository = produtoRepository;
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public Produto criar(Produto produto) {
		
		Optional<Categoria> categoria =categoriaRepository.findById(produto.getCategoria().getIdCategoria());
		
		if(categoria.get() == null) {
			throw new CategoriaInexistenteException();
		}
		
		return produtoRepository.save(produto);		
	}

	@Override
	public Optional<Produto> buscar(Long id) {		
		return produtoRepository.findById(id);
	}

	@Override
	public List<Produto> listarTodas() {		
		return produtoRepository.findAll();
	}

	@Override
	public Produto alterar(Long id,Produto produto) {
		
		Optional<Produto> optProd = produtoRepository.findById(id);
		
		if(optProd.get() == null) {
			throw new ProdutoInexistenteException();
		}
		
		Produto prodSalvo = optProd.get();
		
		BeanUtils.copyProperties(produto, prodSalvo, "idProduto");		
		
		return produtoRepository.save(prodSalvo);
	}

}
