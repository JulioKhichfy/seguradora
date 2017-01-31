package br.com.pequenosdetalhes.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.pequenosdetalhes.modelo.entidades.Usuario;
import br.com.pequenosdetalhes.modelo.repositorios.UsuarioRepositorio;

@Service
public class ServicoUsuario {
	
	@Autowired 
	private UsuarioRepositorio  repositorio;
	 
	
	public Usuario getUsuarioLogado(){
		
		Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
		
		if(autenticado == null) throw new AuthenticationCredentialsNotFoundException("Usuario não autenticado");
		
		UserDetails UsuarioLogado = (UserDetails)autenticado.getPrincipal();
		
		return repositorio.findOneByLogin(UsuarioLogado.getUsername());
		
		
	}

}
