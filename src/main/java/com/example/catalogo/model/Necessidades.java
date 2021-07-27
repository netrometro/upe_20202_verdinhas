package com.example.catalogo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.EntidadeBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "necessidades")
@Setter
@Getter
public class Necessidades extends EntidadeBase {

	@OneToOne(mappedBy = "necessidades")
	private Verdinha verdinha;
	
}
