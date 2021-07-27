package com.example.catalogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.base.EntidadeBase;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "caracteristicas")
@Setter
@Getter
public class Caracteristicas extends EntidadeBase {

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a folhagem")
	@Size(max = 60, min = 2, message = "A caracteristica deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String folhagem;
	
	@Column(name = "cor_folhagem",length = 60, nullable = false)
	@NotBlank(message = "Informe a cor da folhagem")
	@Size(max = 60, min = 2, message = "A cor da folhagem deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String corFolhagem;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o arbustos")
	@Size(max = 60, min = 2, message = "O arbustos deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String arbustos;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe as flores")
	@Size(max = 60, min = 2, message = "As flores deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String flores;
	
	@Column(name = "cor_flores", length = 60, nullable = false)
	@NotBlank(message = "Informe a cor das flores")
	@Size(max = 60, min = 2, message = "A cor das flores deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String corFlores;
	
	@Column(nullable = false)
	@NotBlank(message = "Informe o fruto")
	@Size(max = 60, min = 2, message = "O fruto deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String frutos;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a raíz")
	@Size(max = 60, min = 2, message = "A raíz deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String raizes;
	
	@OneToOne(mappedBy = "caracteristicas")
	private Verdinha verdinha;
	
}
