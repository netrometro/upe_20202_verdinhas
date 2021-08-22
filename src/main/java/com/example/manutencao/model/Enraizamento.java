package com.example.manutencao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.manutencao.model.enuns.TipoIntensidade;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "enraizamento")
@EqualsAndHashCode(callSuper = false)
public class Enraizamento  extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_enraizamento")
	private Long id;
	
	private String observacao;

	private Byte[] fotos;
	
	@OneToMany(mappedBy = "enraizamento")
	private List<Ocorrencia> ocorrencias = new ArrayList<>();

	@Enumerated(EnumType.STRING)
	private TipoIntensidade intensidade;
	
}
