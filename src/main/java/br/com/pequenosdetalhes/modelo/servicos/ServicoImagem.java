package br.com.pequenosdetalhes.modelo.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;
import br.com.pequenosdetalhes.modelo.repositorios.ImagemArtefatoRepositorio;

@Service
public class ServicoImagem {
	
	
	
			
	@Autowired
	private ImagemArtefatoRepositorio imagemRepositorio;
	
	public ImagemArtefato salvar(ImagemArtefato imagem){
		
		imagemRepositorio.save(imagem);
		return imagem;
	}
	
	public ImagemArtefato buscar (long id){
		
		return imagemRepositorio.findById(id);
	}
	
	public void remover(long id){
		ImagemArtefato imagem =  this.buscar(id);
		if(imagem != null ){
			imagemRepositorio.delete(imagem);
		}
		
	}


}
