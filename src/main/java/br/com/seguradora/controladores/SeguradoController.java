package br.com.seguradora.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.seguradora.excecoes.CarroInvalidoException;
import br.com.seguradora.modelo.entidades.Carro;
import br.com.seguradora.modelo.entidades.Segurado;
import br.com.seguradora.modelo.enumeracoes.CategoriaSexo;
import br.com.seguradora.modelo.repositorios.CarroRepositorio;
import br.com.seguradora.modelo.repositorios.SeguradoRepositorio;
import br.com.seguradora.propertyeditors.CarroPropertyEditor;

@Controller
@RequestMapping("/segurados")
public class SeguradoController {
	
	@Autowired private SeguradoRepositorio seguradoRepositorio;
	@Autowired private CarroRepositorio carroRepositorio;
	@Autowired private CarroPropertyEditor carroPropertyEditor;
	
	@RequestMapping("/quantos")
	@ResponseBody
	public String quantosSegurados(){
		return "Atualmente temos " + seguradoRepositorio.count() + " segurado(s) cadastrado(s)";
	}

	@RequestMapping(method=RequestMethod.GET)
	public String listarSegurados(Model model){
		
		model.addAttribute("titulo", "Listagem de Segurados");
		
		model.addAttribute("segurados", seguradoRepositorio.findAll());
		
		model.addAttribute("categoriaSexo", CategoriaSexo.values());
		
		model.addAttribute("carros", carroRepositorio.findAll());
		
		return "segurado/listagem";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvarSegurado(@Valid 
			@ModelAttribute Segurado segurado, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
		
			
			throw new CarroInvalidoException();

		} else {
			seguradoRepositorio.save(segurado);
		}
		model.addAttribute("segurados", seguradoRepositorio.findAll());
		model.addAttribute("categoriaSexo", CategoriaSexo.values());
		
		return "segurado/tabela-segurados";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{seguradoId}")
	public ResponseEntity<String> deletarSegurado(@PathVariable Long seguradoId){
		try {
			seguradoRepositorio.delete(seguradoId);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	/**
	 * 
	 * ResponseEntity pois iremos retornar um json do tipo Segurado
	 */
	@RequestMapping(method=RequestMethod.GET, value="/{seguradoId}")
	public ResponseEntity<Segurado> buscarSegurado(@PathVariable Long seguradoId){
		Segurado segurado = seguradoRepositorio.findOne(seguradoId);
		return new ResponseEntity<>(segurado, HttpStatus.OK); 
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Carro.class, carroPropertyEditor);
	}
	
	/*posso utilizar nomes de paraemtros distintos.
	 * O normal é seguir a convenção e deixar o mesmo nome
	 * como acima
	 * 
	@RequestMapping("/ola/{nomeQualquer}") //
	public String ola(@PathVariable("nomeQualquer") String nome){
		
		return "ola, " + nome;
	}*/

}
