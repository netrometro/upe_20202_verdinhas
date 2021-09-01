package com.example.catalogo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.base.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "verdinha")
@EqualsAndHashCode(callSuper = false)
public class Verdinha extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	private String nome;

	private String especie;

	private String genero;

	private String nomePopular;

	private LocalDate dataAquisicao = LocalDate.now();

	private boolean visivel;

	private byte[] fotos;

	@OneToMany(mappedBy = "verdinha")
	private List<Necessidades> necessidades = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_local")
	private Local local;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_caracteristicas")
	private Caracteristicas caracteristicas;

}
