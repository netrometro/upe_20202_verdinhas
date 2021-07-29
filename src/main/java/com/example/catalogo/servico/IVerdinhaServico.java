package com.example.catalogo.servico;

import java.util.List;

import com.example.catalogo.model.Verdinha;

public interface IVerdinhaServico {
	
	void incluir(Verdinha verdinha);
	
	List<Verdinha> listar();

	void deletar(Verdinha verdinha);
}
