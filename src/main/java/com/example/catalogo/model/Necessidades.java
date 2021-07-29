package com.example.catalogo.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.EntidadeBase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "necessidades")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Necessidades extends EntidadeBase {

	@OneToOne(mappedBy = "necessidades")
	private Verdinha verdinha;
	
}
