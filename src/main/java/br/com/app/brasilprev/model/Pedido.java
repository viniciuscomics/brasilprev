package br.com.app.brasilprev.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "pedido")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID Gerado pelo banco de dados")
	private Long idPedido;
	
	@NotNull
	private LocalDate data;
	
	@NotNull
	@Size(min=3,max=20)	
	private String status;
	
	@NotNull
	@Size(min=3,max=30)	
	private String sessao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente cliente;

}
