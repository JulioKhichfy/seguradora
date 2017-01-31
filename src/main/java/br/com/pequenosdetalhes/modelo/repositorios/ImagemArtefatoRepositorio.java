package br.com.pequenosdetalhes.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;

@Repository
public interface ImagemArtefatoRepositorio extends CrudRepository<ImagemArtefato, Long>{
	

	public ImagemArtefato findById(long id);
	
}
