package br.com.pequenosdetalhes.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pequenosdetalhes.modelo.entidades.Usuario;
import br.com.pequenosdetalhes.modelo.repositorios.UsuarioRepositorio;

@Service
public class ServicoAutenticacao implements UserDetailsService{
	
	@Autowired private UsuarioRepositorio usuarioRepositorio;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario  u = usuarioRepositorio.findOneByLogin(login);
		return u;
	}

}
