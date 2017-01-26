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
import br.com.pequenosdetalhes.modelo.entidades.FestaTema;
import br.com.pequenosdetalhes.modelo.enumeracoes.CategoriaTema;
import br.com.pequenosdetalhes.modelo.repositorios.ArtefatoRepositorio;
import br.com.pequenosdetalhes.modelo.repositorios.FestaTemaRepositorio;
import br.com.pequenosdetalhes.propertyeditors.ArtefatoPropertyEditor;

@Controller
@RequestMapping("/festastemas")
public class FestaTemasController {

	@Autowired
	private FestaTemaRepositorio festaTemaRepositorio;
	@Autowired
	private ArtefatoRepositorio artefatoRepositorio;
	@Autowired
	private ArtefatoPropertyEditor artefatoPropertyEditor;
	
	@InitBinder
	private void dateBinder(WebDataBinder binder) {
		// formatar a data no padrao escolhido "yyyy-MM-dd"
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		// Create a new CustomDateEditor
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		
		// Register it as custom editor for the Date type
		binder.registerCustomEditor(Date.class, editor);
	}

	@RequestMapping("/quantas")
	@ResponseBody
	public String quantosSegurados() {
		return "Atualmente temos " + festaTemaRepositorio.count() + " festa(s) cadastrada(s)";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String listarFestasTemas(Model model) {

		model.addAttribute("titulo", "Listagem de festas tematicas");

		model.addAttribute("festastemas", festaTemaRepositorio.findAll());

		model.addAttribute("categoriaTema", CategoriaTema.values());

		model.addAttribute("artefatos", artefatoRepositorio.findAll());

		return "festatema/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarFestaTema(@Valid
			@ModelAttribute FestaTema festaTema, 
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			throw new CarroInvalidoException();

		} else {
			festaTemaRepositorio.save(festaTema);
		}
		model.addAttribute("festastemas", festaTemaRepositorio.findAll());
		model.addAttribute("categoriaTema", CategoriaTema.values());

		return "festatema/tabela-festastemas";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{festaTemaId}")
	public ResponseEntity<String> deletarSegurado(@PathVariable Long festaTemaId) {
		try {
			festaTemaRepositorio.delete(festaTemaId);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

	}

	/**
	 * 
	 * ResponseEntity pois iremos retornar um json do tipo Segurado
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{festaTemaId}")
	public ResponseEntity<FestaTema> buscarFestaTema(@PathVariable Long festaTemaId) {
		FestaTema festaTema = festaTemaRepositorio.findOne(festaTemaId);
		return new ResponseEntity<>(festaTema, HttpStatus.OK);
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(Artefato.class, artefatoPropertyEditor);
	}

	/*
	 * posso utilizar nomes de paraemtros distintos. O normal é seguir a
	 * convenção e deixar o mesmo nome como acima
	 * 
	 * @RequestMapping("/ola/{nomeQualquer}") // public String
	 * ola(@PathVariable("nomeQualquer") String nome){
	 * 
	 * return "ola, " + nome; }
	 */

}
