package com.example.catalogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.GenericEntity;
import com.example.catalogo.model.enuns.TipoExposicaoSolar;
import com.example.catalogo.model.enuns.TipoFrequencia;
import com.example.catalogo.model.enuns.TipoIncidenciaSolar;
import com.example.catalogo.model.enuns.TipoPodaLimpeza;
import com.example.catalogo.model.enuns.TipoPropagacao;
import com.example.catalogo.model.enuns.TipoRega;
import com.example.catalogo.model.enuns.TipoSubstrato;
import com.example.catalogo.model.enuns.TipoVaso;
import com.example.catalogo.model.enuns.TipoVento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "verdinhas_necessidades")
@EqualsAndHashCode(callSuper = true)
public class Necessidades extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	
	@OneToOne(mappedBy = "necessidades")
	private Verdinha verdinha;
	
	private TipoIncidenciaSolar incidenciaSolar;
	
	private TipoExposicaoSolar exposicaoSolar;
	
	private TipoRega rega;
	
	private TipoFrequencia tipoFrequencia;
	
	private TipoVento vento ;
	
	private TipoSubstrato substrato;
	
	private TipoVaso vaso;
	
	private TipoPodaLimpeza podaLimpeza;
	
	private TipoPropagacao propagacao;
	
}
