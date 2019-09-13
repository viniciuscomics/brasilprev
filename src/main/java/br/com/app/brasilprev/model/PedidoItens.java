package br.com.app.brasilprev.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pedidoItens")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PedidoItens implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID Gerado pelo banco de dados")
	private Long idItem;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private BigDecimal subtotal;
		
	private int quantidade;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idProduto")
	private Produto produto; 
	
	
}