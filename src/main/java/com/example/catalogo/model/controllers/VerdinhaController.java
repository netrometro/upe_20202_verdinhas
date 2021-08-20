package com.example.catalogo.model.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogo.model.Verdinha;

@RequestMapping("/api/v1/verdinha")
@RestController
public class VerdinhaController {

	@GetMapping
	public ResponseEntity<List<Verdinha>> fetchAll() {
		return null;
	}
	
	public ResponseEntity<Verdinha> fetch(@PathVariable Long verdinhaId) {
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Verdinha> create(@RequestBody @Valid Verdinha verdinha) {
		return null;
	}
	
	public ResponseEntity<Verdinha> update(
			@PathVariable Long verdinhaId, @RequestBody @Valid Verdinha verdinha) {
		return null;
	}
	
	@DeleteMapping("/{verdinhaId}")
	public ResponseEntity<Verdinha> delete(@PathVariable Long verdinhaId) {
		return null;
	}
	
}
