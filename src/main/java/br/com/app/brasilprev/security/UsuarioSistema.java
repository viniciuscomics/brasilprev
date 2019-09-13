package br.com.app.brasilprev.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.app.brasilprev.model.Cliente;

public class UsuarioSistema extends User{	
	
	private static final long serialVersionUID = 1L;
	
	private Cliente user;
	
	public UsuarioSistema(Cliente user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getSenha(), authorities);
		this.user = user;
	}
	
	public Cliente getUser() {
		return user;
	}

}