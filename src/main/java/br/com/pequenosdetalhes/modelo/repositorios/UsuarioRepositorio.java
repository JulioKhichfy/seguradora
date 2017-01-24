package br.com.pequenosdetalhes.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pequenosdetalhes.modelo.entidades.Usuario;

@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Long>{

	public Usuario findOneByLogin(String login);

}
