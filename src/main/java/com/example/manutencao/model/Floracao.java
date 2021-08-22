package com.example.manutencao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.manutencao.model.enuns.TipoIntensidade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "floracao")
@EqualsAndHashCode(callSuper = false)
public class Floracao extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_floracao")
	private Long id;
	
	private boolean haste;
	private String observacao;
	private byte[] fotos;
	
	@ManyToOne
	@JoinColumn(name = "id_ocorrencia")
	private Ocorrencia ocorrencia;
	
	@Enumerated(EnumType.STRING)
	private TipoIntensidade tipoIntensidade;
	
}
