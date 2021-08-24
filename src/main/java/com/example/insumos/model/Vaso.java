package com.example.insumos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.base.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "vaso")
@EqualsAndHashCode(callSuper = false)
public class Vaso extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_vaso")
	private Long id;
	
	private String nome;
	
	private String composicao;
	
	private byte[] fotos;
	
	private Integer quantidade;
	
	private String observacao;
	
	@Transient
	private String tipo;
}
