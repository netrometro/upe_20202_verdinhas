package com.example.manutencao.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.base.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "patologia")
@EqualsAndHashCode(callSuper = false)
public class Patologia extends GenericEntity {
	private static final long serialVersionUID = 1L;

	private String observacao;
	
	private Byte[] fotos;
	
}
