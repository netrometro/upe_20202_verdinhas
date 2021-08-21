package com.example.manutencao.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.manutencao.model.enuns.TipoOcorrencia;

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_patologia")
	private Patologia patologias;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_floracao", referencedColumnName = "id_floracao")
	private Floracao floracao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_frutificacao", referencedColumnName = "id_frutificacao")
	private Frutificacao frutificacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_enraizamento", referencedColumnName = "id_enraizamento")
	private Enraizanamento enraizanamento;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_brotacao", referencedColumnName = "id_brotacao")
	private Brotacao brotacao;
	
	@Enumerated(EnumType.STRING)
	private TipoOcorrencia tipoOcorrencia;
	
}
