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

@RequestMapping("/api/v1/verdinha")
@RestController
public class VerdinhaController {

	@Autowired
	private IVerdinhaCRUDService crudService;
	
	@Autowired
	private ResponseService responseService;
	
	@GetMapping
	public ResponseEntity<?> fetchAll() {
		return responseService.create(crudService.fetchAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{verdinhaId}")
	public ResponseEntity<?> fetch(@PathVariable Long verdinhaId) {
		return responseService.create(crudService.fetch(verdinhaId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody @Valid Verdinha verdinha) {
		return responseService.create(crudService.insert(verdinha), HttpStatus.OK);
	}
	
	@PutMapping("/{verdinhaId}")
	public ResponseEntity<?> update(
			@PathVariable Long verdinhaId, @RequestBody @Valid Verdinha verdinha) {
		return responseService.create(crudService.update(verdinha), HttpStatus.OK);
	}
	
	@DeleteMapping("/{verdinhaId}")
	public ResponseEntity<?> delete(@PathVariable Long verdinhaId) {
		return responseService.create(crudService.delete(verdinhaId), HttpStatus.OK);
	}
	
}
