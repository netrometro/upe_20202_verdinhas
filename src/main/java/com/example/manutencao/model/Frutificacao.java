package com.example.manutencao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.manutencao.model.enuns.TipoIntensidade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "frutificacao")
@EqualsAndHashCode(callSuper = false)
public class Frutificacao  extends GenericEntity {
	private static final long serialVersionUID = 1L;
	
	private String observacao;
	private byte[] fotos;

	@OneToOne(mappedBy = "frutificacao")
	private Ocorrencia ocorrencia;
	
	@Enumerated(EnumType.STRING)
	private TipoIntensidade intensidade;
	
}
