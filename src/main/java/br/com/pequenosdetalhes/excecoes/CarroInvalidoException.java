package br.com.pequenosdetalhes.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class CarroInvalidoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

}
