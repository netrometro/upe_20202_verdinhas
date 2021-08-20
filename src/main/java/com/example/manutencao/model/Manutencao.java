package com.example.manutencao.model;

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
@Table(name = "manutencao")
@EqualsAndHashCode(callSuper = false)
public class Manutencao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_manutencao")
	private Long id;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome da manutenção")
	@NotNull
	@Size(max = 60, min = 2, message = "O nome deve ter no máximo {max} 60 caracteres e no mínimo {min} 2 caracteres")
	private String nome;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a observação da manutenção")
	@NotNull
	@Size(max = 60, min = 2, message = "A observação deve ter no máximo {max} 60 caracteres e no mínimo {min} 2 caracteres")
	private String observacao;
	
	private byte[] fotos;

}
