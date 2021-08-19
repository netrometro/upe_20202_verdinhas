package com.example.insumos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "verdinhas_adubo")
@EqualsAndHashCode(callSuper = false)
public class Adubo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_adubo")
	private Long id;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome do adubo")
	@NotNull
	@Size(max = 60, min = 5, message = "O nome do adubo deve ter no máximo {max} 60 caracteres e no mínimo {min} 5 caracteres")
	private String nome;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a composição")
	@NotNull
	@Size(max = 60, min = 5, message = "A Composição deve ter no máximo {max} 60 caracteres e no mínimo {min} 5 caracteres")
	private String composicao;
	
	private Integer quantidade;
	
	private byte[] foto;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a observação")
	@NotNull
	@Size(max = 60, min = 5, message = "A observação deve ter no máximo {max} 60 caracteres e no mínimo {min} 5 caracteres")
	private String observacao;
	
}


