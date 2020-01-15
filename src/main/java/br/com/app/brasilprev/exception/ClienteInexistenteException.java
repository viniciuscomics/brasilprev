package br.com.app.brasilprev.exception;

public class ClienteInexistenteException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClienteInexistenteException() {		
	}
	
	public ClienteInexistenteException(String msgErro) {
		super(msgErro);
	}

}
