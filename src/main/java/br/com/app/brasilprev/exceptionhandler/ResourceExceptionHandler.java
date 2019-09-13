package br.com.app.brasilprev.exceptionhandler;

import java.util.Arrays;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.app.brasilprev.exceptionhandler.SistemaExceptionHandler.Erro;
import br.com.app.brasilprev.exception.ProdutoInexistenteException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler({ProdutoInexistenteException.class})
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(ProdutoInexistenteException ex){
		return parseResponse(ex,"recurso.nao-encontrado"); 
	}

	private ResponseEntity<Object> parseResponse(Exception ex, String chave) {
		String msgUser = messageSource.getMessage(chave,null,LocaleContextHolder.getLocale());
		String msgDev = ExceptionUtils.getRootCauseMessage(ex);
		
		return ResponseEntity.badRequest().body(Arrays.asList(new Erro(msgUser,msgDev)));
	}

}
