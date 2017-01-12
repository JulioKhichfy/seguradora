package br.com.seguradora.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.seguradora.modelo.entidades.Carro;
import br.com.seguradora.modelo.repositorios.CarroRepositorio;

@Component
public class CarroPropertyEditor extends PropertyEditorSupport  {
	
@Autowired private CarroRepositorio carroRepositorio;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idCarro = Long.parseLong(text);
		Carro carro = carroRepositorio.findOne(idCarro);
		setValue(carro);
	}

}
