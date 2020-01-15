package br.com.app.brasilprev.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

/**
 * Classe responsavel por disparar evento quando um recurso for criado.
 * @author v.costa.santos.alves
 *
 */

public class RecursoCriadoEvent extends ApplicationEvent{

	private static final long serialVersionUID = 1L;
	private Long id;
	private HttpServletResponse response;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.id = id;
	}

	public Long getId() {
		return id;
	}	

	public HttpServletResponse getResponse() {
		return response;
	}	

}

