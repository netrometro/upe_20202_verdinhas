package com.example.catalogo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.base.GenericEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "verdinhas_verdinha")
@EqualsAndHashCode(callSuper = false)
public class Verdinha extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome da planta")
	@NotNull
	@Size(max = 60, min = 2, message = "O nome deve ter no máximo {max} 60 caracteres e no mínimo {min} 2 caracteres")
	private String nome;

	@Column(length = 40, nullable = false)
	@NotBlank(message = "Informe o nome da especie")
	@NotNull
	@Size(max = 40, min = 2, message = "O nome deve ter no máximo {max} 40 caracteres e no mínimo {min} 2 caracteres")
	private String especie;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Informe o gênero")
	@NotNull
	@Size(max = 30, min = 2, message = "O nome deve ter no máximo {max} 30 caracteres e no mínimo {min} 2 caracteres")
	private String genero;

	@Column(length = 40, nullable = false)
	@NotBlank(message = "Informe o nome popular")
	@NotNull
	@Size(max = 40, min = 2, message = "O nome deve ter no máximo {max} 40 caracteres e no mínimo {min} 2 caracteres")
	private String nomePopular;

	@Column(nullable = false)
	private LocalDate dataAquisicao = LocalDate.now();

	private boolean visivel;

	private byte[] fotos;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_necessidades")
	private Necessidades necessidades;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_local")
	private Local local;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_caracteristicas")
	private Caracteristicas caracteristicas;

}
