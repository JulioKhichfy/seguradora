package br.com.pequenosdetalhes.propertyeditors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.repositorios.ArtefatoRepositorio;

@Component
public class ArtefatoPropertyEditor extends PropertyEditorSupport  {
	
@Autowired private ArtefatoRepositorio artefatoRepositorio;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		long idArtefato = Long.parseLong(text);
		Artefato artefato = artefatoRepositorio.findOne(idArtefato);
		setValue(artefato);
	}

}
