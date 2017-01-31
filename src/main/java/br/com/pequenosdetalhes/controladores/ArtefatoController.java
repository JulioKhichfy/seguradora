package br.com.pequenosdetalhes.controladores;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.pequenosdetalhes.excecoes.CarroInvalidoException;
import br.com.pequenosdetalhes.modelo.entidades.Artefato;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaCor;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaMaterial;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaTipoArtefato;
import br.com.pequenosdetalhes.modelo.servicos.ServicoArtefato;


// app/carros (metodo GET) --> vai cair no metodo listarCarros
// app/carros (metodo POST) --> vai cair no metodo salvarCarro

@Controller
@RequestMapping("/artefatos")
public class ArtefatoController {
	
	//private static final Logger logger = LoggerFactory.getLogger(ArtefatoController.class);

	
	
	@Autowired
	//private ArtefatoRepositorio artefatoRepositorio;
	private ServicoArtefato servicoArtefato;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		// formatar a data no padrao escolhido "yyyy-MM-dd"
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String listarArtefatos(Model model) {
		model.addAttribute("titulo", "Listagem de Artefatos");
		
		Iterable<Artefato> artefatos = servicoArtefato.listar();
		
		model.addAttribute("artefatos", artefatos);
				
		model.addAttribute("categoriaCor", CategoriaCor.values());
		
		model.addAttribute("categoriaMaterial", CategoriaMaterial.values());
		
		model.addAttribute("categoriaTipoArtefato", CategoriaTipoArtefato.values());

		return "artefato/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarArtefato(@Valid 
			@ModelAttribute Artefato artefato, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
		
			throw new CarroInvalidoException();

		} else {
			
			if(artefato.getId()!=null){
				Artefato artefatoOld = servicoArtefato.buscar(artefato.getId());
				artefatoOld.setNome(artefato.getNome());
				servicoArtefato.remover(artefato.getId());
				servicoArtefato.salvar(artefatoOld);
			}else
			
				servicoArtefato.salvar(artefato);
	 
		}
		
		model.addAttribute("artefatos", servicoArtefato.listar());
		model.addAttribute("categoriaCor", CategoriaCor.values());
		model.addAttribute("categoriaMaterial", CategoriaMaterial.values());
		model.addAttribute("categoriaTipoArtefato", CategoriaTipoArtefato.values());
		
		return "artefato/tabela-artefatos";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarArtefato(@PathVariable Long id){
		try {
			servicoArtefato.remover(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody//obrigar o spring a retornar xml ou json
	public Artefato buscarArtefato(@PathVariable Long id){
		Artefato artefato = servicoArtefato.buscar(id);
		return artefato;
	}
}
