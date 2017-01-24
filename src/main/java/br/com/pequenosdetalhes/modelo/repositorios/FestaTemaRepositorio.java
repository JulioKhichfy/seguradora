package br.com.pequenosdetalhes.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pequenosdetalhes.modelo.entidades.FestaTema;

@Repository
public interface FestaTemaRepositorio extends CrudRepository<FestaTema, Long> {

}
