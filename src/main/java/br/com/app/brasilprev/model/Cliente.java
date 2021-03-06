package br.com.app.brasilprev.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "ID Gerado pelo banco de dados")
	private Long idCliente;
	
	@NotNull
	@Size(min=3,max=30)	
	private String nome;
	
	@NotNull
	@Size(min=3,max=30)	
	private String email;
	
	@NotNull	
	private String senha;
	
	@NotNull
	@Size(min=3,max=30)	
	private String rua;
	
	@NotNull
	@Size(min=3,max=30)	
	private String cidade;
	
	@NotNull
	@Size(min=3,max=30)	
	private String bairro;
	
	@NotNull
	@Size(min=8,max=8)	
	private String cep;
	
	@NotNull
	@Size(min=3,max=30)	
	private String estado;

}
