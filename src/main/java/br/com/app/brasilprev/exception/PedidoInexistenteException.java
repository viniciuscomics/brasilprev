package br.com.app.brasilprev.exception;

public class PedidoInexistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PedidoInexistenteException() {}
	
	public PedidoInexistenteException(String msgErro) {
		super(msgErro);
	}

}
