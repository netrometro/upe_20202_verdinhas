package com.example.catalogo.servicos;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.catalogo.model.Verdinha;

@Service
public interface IVerdinhaServicos {
	
	void incluir(Verdinha verdinha);
	
	List<Verdinha> listar();

	void deletar(Verdinha verdinha);
}
