package com.example.catalogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "necessidades")
@EqualsAndHashCode(callSuper = true)
public class Necessidades extends GenericEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_verdinha")
	private Verdinha verdinha;

	@Enumerated(EnumType.STRING)
	private TipoIncidenciaSolar incidenciaSolar;

	@Enumerated(EnumType.STRING)
	private TipoExposicaoSolar exposicaoSolar;

	@Enumerated(EnumType.STRING)
	private TipoRega rega;

	@Enumerated(EnumType.STRING)
	private TipoFrequencia tipoFrequencia;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_vento")
	private TipoVento vento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_substrato")
	private TipoSubstrato substrato;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_vaso")
	private TipoVaso vaso;

	@Enumerated(EnumType.STRING)
	private TipoPodaLimpeza podaLimpeza;

	@Enumerated(EnumType.STRING)
	private TipoPropagacao propagacao;

}
