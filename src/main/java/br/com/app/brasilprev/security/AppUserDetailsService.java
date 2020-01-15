package br.com.app.brasilprev.security;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.app.brasilprev.model.Cliente;
import br.com.app.brasilprev.model.Users;
import br.com.app.brasilprev.repository.ClienteRepository;
import br.com.app.brasilprev.repository.UsersRepository;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> opt = usersRepository.findByEmail(username);
		Users user = opt.orElseThrow(()->new UsernameNotFoundException("Usuario ou senha invalidos"));
		
		return new UsuarioSistema(user,new HashSet<SimpleGrantedAuthority>());
	}	
}
