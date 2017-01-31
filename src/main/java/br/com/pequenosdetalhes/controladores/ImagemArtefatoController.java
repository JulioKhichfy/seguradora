package br.com.pequenosdetalhes.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;
import br.com.pequenosdetalhes.modelo.servicos.ServicoArtefato;
import br.com.pequenosdetalhes.modelo.servicos.ServicoImagem;

@Controller
@RequestMapping("/imagens")
public class ImagemArtefatoController {
	
		
	@Autowired
	private ServicoArtefato servicoArtefato;
	
	@Autowired
	private ServicoImagem servicoImagem;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "Upload";
    }
     
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload, @RequestParam String id_image) throws Exception {
        
    	
    	Long id = Long.parseLong(id_image.split(",")[0]);
    	System.out.println(id);
    	Artefato artefato = servicoArtefato.buscar(id);
    	Set<ImagemArtefato> allImgs = artefato.getImagensArtefatos();

    	if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
            	if(aFile.getSize()>0){ 
            		System.out.println("Saving file: " + aFile.getOriginalFilename());
            		ImagemArtefato uploadFile = new ImagemArtefato();
            		
            		uploadFile.setFileName(aFile.getOriginalFilename());
            		uploadFile.setData(aFile.getBytes());
            		ImagemArtefato img= servicoImagem.salvar(uploadFile);
            		allImgs.add(img);
            	
            	}
                
            }
            artefato.setImagensArtefatos(allImgs);
            servicoArtefato.salvar(artefato);
        }
  
        return "redirect:/artefatos";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="{buscarImagensArtefato}/{id}")
	@ResponseBody//obrigar o spring a retornar xml ou json
	public List<ImagemArtefato> buscarImagensArtefato(@PathVariable Long id){
		Artefato artefato = servicoArtefato.buscar(id);
		
		Set<ImagemArtefato> imgs = artefato.getImagensArtefatos();
		List<ImagemArtefato> imageList = new ArrayList<ImagemArtefato>();
		imageList.addAll(imgs);
	
		
		return imageList;
		
	}
    
    @RequestMapping(method=RequestMethod.DELETE, value="{deletarImagemArtefato}/{id}")
	public ResponseEntity<String> deletarImagemArtefato(@PathVariable Long id){
		try {
			
			ImagemArtefato imagem = servicoImagem.buscar(id);
			Artefato artefato = servicoArtefato.findByImagensArtefatos(imagem);
			
			artefato.getImagensArtefatos().remove(imagem);
			servicoArtefato.salvar(artefato);
			servicoImagem.remover(imagem.getId());
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}

}
