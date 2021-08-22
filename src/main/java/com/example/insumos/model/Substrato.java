package com.example.insumos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "substrato")
@EqualsAndHashCode(callSuper = false)
public class Substrato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_substrato")
	private Long id;
	
	private String nome;
	private String composicao;
	private byte[] fotos;
	private Integer quantidade;
	private String observacao;
	
	@Transient
	private String tipo;
		
}