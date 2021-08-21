package com.example.manutencao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.manutencao.model.enuns.TipoManutencao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "lembrete")
@EqualsAndHashCode(callSuper = false)
public class Lembrete extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_lembrete")
	private Long id;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoManutencao manutencao;

}
