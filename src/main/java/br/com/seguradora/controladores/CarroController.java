package br.com.seguradora.controladores;


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

import br.com.seguradora.excecoes.CarroInvalidoException;
import br.com.seguradora.modelo.entidades.Carro;
import br.com.seguradora.modelo.enumeracoes.CategoriaCarroceria;
import br.com.seguradora.modelo.enumeracoes.CategoriaCombustivel;
import br.com.seguradora.modelo.repositorios.CarroRepositorio;

// app/carros (metodo GET) --> vai cair no metodo listarCarros
// app/carros (metodo POST) --> vai cair no metodo salvarCarro

@Controller
@RequestMapping("/carros")
public class CarroController {

	@Autowired
	private CarroRepositorio carroRepositorio;
	
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
	public String listarCarros(Model model) {
		model.addAttribute("titulo", "Listagem de Carros");

		Iterable<Carro> carros = carroRepositorio.findAll();
		
		model.addAttribute("carros", carros);
				
		model.addAttribute("categoriaCombustivel", CategoriaCombustivel.values());
		
		model.addAttribute("categoriaCarroceria", CategoriaCarroceria.values());

		return "carro/listagem";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvarCarro(@Valid 
			@ModelAttribute Carro carro, 
			BindingResult bindingResult,
			Model model) {
		
		if (bindingResult.hasErrors()) {
		
			throw new CarroInvalidoException();

		} else {
			carroRepositorio.save(carro);
	
		}
		model.addAttribute("carros", carroRepositorio.findAll());
		model.addAttribute("categoriaCombustivel", CategoriaCombustivel.values());
		model.addAttribute("categoriaCarroceria", CategoriaCarroceria.values());
		
		return "carro/tabela-carros";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> deletarCarro(@PathVariable Long id){
		try {
			carroRepositorio.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception ex){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody//obrigar o spring a retornar xml ou json
	public Carro buscarCarro(@PathVariable Long id){
		Carro carro = carroRepositorio.findOne(id);
		return carro;
	}

}
