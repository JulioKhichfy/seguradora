package br.com.seguradora.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seguradora.modelo.entidades.Carro;

@Repository
public interface CarroRepositorio extends CrudRepository<Carro, Long> { //uso Long pois é o tipo do ID no modelo

}
