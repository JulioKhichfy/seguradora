package br.com.pequenosdetalhes.modelo.repositorios;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;
import br.com.pequenosdetalhes.modelo.entidades.Usuario;

@Repository
public interface ArtefatoRepositorio extends CrudRepository<Artefato, Long> { //uso Long pois é o tipo do ID no modelo

	public Artefato findByImagensArtefatos(ImagemArtefato img);
	
	public List<Artefato> findAllByUsuario(Usuario usuario);
	
	public Artefato findByIdAndUsuario(long id, Usuario usuario);
	
	public Set<ImagemArtefato> findImagensArtefatosById(long id);
	
	public void removeImagensArtefatosById(long id);
	
}
