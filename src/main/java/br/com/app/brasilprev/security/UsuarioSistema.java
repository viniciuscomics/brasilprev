package br.com.app.brasilprev.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.model.Users;

public class UsuarioSistema extends User{	
	
	private static final long serialVersionUID = 1L;
	
	private Users user;
	
	public UsuarioSistema(Users user, Collection<? extends GrantedAuthority> authorities) {
		super(user.getEmail(), user.getSenha(), authorities);
		this.user = user;
	}
	
	public Users getUser() {
		return user;
	}

}