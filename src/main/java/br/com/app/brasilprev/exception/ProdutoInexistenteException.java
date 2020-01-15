package br.com.app.brasilprev.exception;

public class ProdutoInexistenteException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdutoInexistenteException() {}
	
	public ProdutoInexistenteException(String msgErro) {
		super(msgErro);
	}

}
