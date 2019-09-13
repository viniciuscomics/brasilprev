package br.com.app.brasilprev.utils;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

public class Utils {

	public static ResponseEntity<?> montarResponseEntity(Optional<?> entity){		
		return entity.orElse(null) != null ? ResponseEntity.ok(entity) : ResponseEntity.noContent().build();
	}
	
}
