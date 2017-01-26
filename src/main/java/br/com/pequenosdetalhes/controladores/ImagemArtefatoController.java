package br.com.pequenosdetalhes.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.entidades.ImagemArtefato;
import br.com.pequenosdetalhes.modelo.repositorios.ImagemArtefatoRepositorio;

@Controller
public class ImagemArtefatoController {
	
	@Autowired
	private ImagemArtefatoRepositorio imagemArtefatoRepositorio;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "Upload";
    }
     
    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload, @RequestParam String id_image) throws Exception {
        
    	
    	Long id = Long.parseLong(id_image.split(",")[0]);
    	System.out.println(id);
    	
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
            	if(aFile.getSize()>0){ 
            		System.out.println("Saving file: " + aFile.getOriginalFilename());
            		ImagemArtefato uploadFile = new ImagemArtefato();
            		uploadFile.setFileName(aFile.getOriginalFilename());
            		uploadFile.setData(aFile.getBytes());
            		ImagemArtefato img= imagemArtefatoRepositorio.save(uploadFile);
            	
            	}
                
            }
        }
  
        return "redirect:artefatos";
    }  

}
