package br.com.app.brasilprev.exception;

public class CategoriaInexistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CategoriaInexistenteException() {}
	
	public CategoriaInexistenteException(String msgErro) {
		super(msgErro);
	}

}