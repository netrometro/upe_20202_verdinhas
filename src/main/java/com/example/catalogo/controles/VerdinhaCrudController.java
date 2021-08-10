package com.example.catalogo.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.model.Verdinha;
import com.example.catalogo.services.VerdinhaCRUDService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/crudapi/verdinhas")
@Slf4j
public class VerdinhaCRUDController {

	@Autowired
	private VerdinhaCRUDService verdinhaCRUDService;
	
	@RequestMapping(value = "/verdinhas")
	public ResponseEntity<?> getVerdinhas() {
		return new ResponseEntity<>(verdinhaCRUDService.getVerdinhas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/verdinhas/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> 
		update(@PathVariable("id") Long id, @RequestBody Verdinha verdinha ) {
			
		verdinhaCRUDService.update(id, verdinha);
		return new ResponseEntity<>("Verdinha atualizada com sucesso", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/verdinhas/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {	
		verdinhaCRUDService.delete(id);
		return new ResponseEntity<>("Verdinha excluida com sucesso", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/verdinhas", method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Verdinha verdinha ) {
		verdinhaCRUDService.create(verdinha);
		return new ResponseEntity<>("Verdinha cadastrada com sucesso", HttpStatus.OK);
	}
	
}
