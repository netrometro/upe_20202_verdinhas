package com.example.manutencao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.manutencao.model.enuns.TipoBrotacao;
import com.example.manutencao.model.enuns.TipoIntensidade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "brotacao")
@EqualsAndHashCode(callSuper = false)
public class Brotacao extends GenericEntity {
	private static final long serialVersionUID = 1L;

	private String observacao;

	private Byte[] fotos;

	@OneToOne(mappedBy = "brotacao")
	private Ocorrencia ocorrencia;
	
	@Enumerated(EnumType.STRING)
	private TipoBrotacao tipoBrotacao;
	
	@Enumerated(EnumType.STRING)
	private TipoIntensidade intensidade;
	
}
