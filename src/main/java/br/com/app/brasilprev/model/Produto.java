package br.com.app.brasilprev.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "produto")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idProduto;
	
	@NotNull
	@Size(min=3,max=30)	
	private String produto;
	
	@NotNull		
	private BigDecimal preco;
	
	private int quantidade;
	
	@NotNull
	@Size(min=3,max=30)	
	private String descricao;
		
	private byte[]foto;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCategoria")
	private Categoria categoria; 
	

}
