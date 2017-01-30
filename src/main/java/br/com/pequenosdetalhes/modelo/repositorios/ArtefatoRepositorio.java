package br.com.pequenosdetalhes.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;

@Repository
public interface ArtefatoRepositorio extends CrudRepository<Artefato, Long> { //uso Long pois é o tipo do ID no modelo

	public Artefato findByImagensArtefatos(ImagemArtefato img);
}
