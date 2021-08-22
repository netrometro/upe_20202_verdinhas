package com.example.manutencao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "ocorrencia")
@EqualsAndHashCode(callSuper = false)
public class Ocorrencia {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_manutencao")
	private Long id;

	private String observacao;

	@ManyToOne
	@JoinColumn(name = "id_enraizamento")
	private Enraizamento enraizamento;
	
	@OneToMany(mappedBy = "ocorrencia")
	private List<Brotacao> brotacaos = new ArrayList<>();
	
	@OneToMany(mappedBy = "ocorrencia")
	private List<Floracao> floraca = new ArrayList<>();
	
	@OneToMany(mappedBy = "ocorrencia")
	private List<Frutificacao> frutificacao = new ArrayList<>();
	
	@OneToMany(mappedBy = "ocorrencia")
	private List<Patologia> patologias = new ArrayList<>();
	
}

