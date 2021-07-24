package com.example.catalogo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.base.EntidadeBase;

@Entity
@Table(name = "verdinhas")
public class Verdinha extends EntidadeBase {

	@Column(length = 60, nullable = false)
	//@NotBlank(message = "Informe o nome do vendedor")
	//@Size(max = 60, min = 2, message = "O nome deve ter no máximo {max} 60 caracteres e no mínimo {min} 2 caracteres")
	private String nome;
	
	private String especie;
	
	private String genero;
	
	private String nomePopular;
	
	@Column(nullable = false)
	private LocalDate dataAquisicao = LocalDate.now();
	
	private boolean visivel;
	
	private byte[] fotos;
	
}
