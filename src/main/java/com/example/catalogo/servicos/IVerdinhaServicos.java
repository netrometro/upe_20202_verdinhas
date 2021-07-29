package com.example.catalogo.servicos;

import java.util.List;

import com.example.catalogo.model.Verdinha;

public interface IVerdinhaServicos {
	
	void incluir(Verdinha verdinha);
	
	List<Verdinha> listar();

	void deletar(Verdinha verdinha);
}
