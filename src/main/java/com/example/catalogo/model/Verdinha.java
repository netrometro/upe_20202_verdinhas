package com.example.catalogo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Verdinha {

	private static final long serialVersionUID = 1L;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome da planta")
	@Size(max = 60, min = 2, message = "O nome deve ter no máximo {max} 60 caracteres e no mínimo {min} 2 caracteres")
	private String nome;

	@Column(length = 40, nullable = false)
	@NotBlank(message = "Informe o nome da especie")
	@Size(max = 40, min = 2, message = "O nome deve ter no máximo {max} 40 caracteres e no mínimo {min} 2 caracteres")
	private String especie;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Informe o gênero")
	@Size(max = 30, min = 2, message = "O nome deve ter no máximo {max} 30 caracteres e no mínimo {min} 2 caracteres")
	private String genero;

	@Column(length = 40, nullable = false)
	@NotBlank(message = "Informe o nome popular")
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
