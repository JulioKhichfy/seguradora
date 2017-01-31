package br.com.pequenosdetalhes.modelo.servicos;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;
import br.com.pequenosdetalhes.modelo.repositorios.ArtefatoRepositorio;

@Service
public class ServicoArtefato {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	@Autowired
	private ArtefatoRepositorio repositorioArtefato;
	
	public void salvar(Artefato artefato){
		artefato.setUsuario(servicoUsuario.getUsuarioLogado());
		repositorioArtefato.save(artefato);
	}
	
	
	
	public Iterable<Artefato> listar (){
		return repositorioArtefato.findAllByUsuario(servicoUsuario.getUsuarioLogado());
	}
	
	public Artefato buscar (long id){
		
		return repositorioArtefato.findByIdAndUsuario(id, servicoUsuario.getUsuarioLogado());
	}
	
	public void remover(long id){
		Artefato artefato =  this.buscar(id);
		if(artefato != null ){
			repositorioArtefato.delete(artefato);
		}
		
		
	}
	
	public Artefato findByImagensArtefatos(ImagemArtefato imagem){
		
		return repositorioArtefato.findByImagensArtefatos(imagem);
		
	}
	
	public Set<ImagemArtefato> findImagensArtefatosById(long id ){
		
		return repositorioArtefato.findImagensArtefatosById(id);
		
	}

}
