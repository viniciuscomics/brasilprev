package br.com.app.brasilprev.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.app.brasilprev.event.RecursoCriadoEvent;

/**
 * Classe responsavel por escutar o evento de recurso criado e montar o header.
 * @author v.costa.santos.alves
 *
 */

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEvent>{

	@Override
	public void onApplicationEvent(RecursoCriadoEvent event) {
		
		HttpServletResponse response = event.getResponse();
		Long id = event.getId();		
		adicionarHeader(response, id);
	}

	private void adicionarHeader(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

	
}

