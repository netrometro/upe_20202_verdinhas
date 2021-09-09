package com.example.catalogo.model.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.interfaces.IVerdinhaCRUDService;
import com.example.catalogo.model.Verdinha;
import com.example.catalogo.services.serializers.ResponseService;

@RestController
@RequestMapping(value = "/api/verdinhas")
public class VerdinhaController {

	@Autowired
	private IVerdinhaCRUDService crudService;
	
	@Autowired
	private ResponseService responseService;

	 @GetMapping
	  public ResponseEntity<?> fetchAll() {
	    return responseService.create(crudService.fetchAll(), HttpStatus.OK);
	  }

	  @GetMapping("/{id}")
	  public ResponseEntity<?> fetch(
	    @PathVariable Long id)
	  {
	    return responseService.create(crudService.fetch(id), HttpStatus.OK);
	  }

	  @PostMapping
	  public ResponseEntity<?> create(
	    @RequestBody @Valid Verdinha verdinha)
	  {
	    return responseService.create(crudService.insert(verdinha), HttpStatus.OK);
	  }

	  @PutMapping("/{id}")
	  public ResponseEntity<?> update(
	    @PathVariable Long id,
	    @RequestBody @Valid Verdinha verdinha)
	  {
	    return responseService.create(crudService.update(verdinha), HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> delete(@PathVariable Long id) {
		crudService.delete(id);
	    return ResponseEntity.noContent().build();
	  }
	
}
