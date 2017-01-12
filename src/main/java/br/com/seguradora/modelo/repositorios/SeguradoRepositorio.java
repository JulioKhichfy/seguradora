package br.com.seguradora.modelo.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.seguradora.modelo.entidades.Segurado;

@Repository
public interface SeguradoRepositorio extends CrudRepository<Segurado, Long> {

}
