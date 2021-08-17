package com.example.catalogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.base.GenericEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "local")
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Local extends GenericEntity {

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome do local")
	@Size(max = 60, min = 2, message = "O nome do local deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String nome;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a descrição do local")
	@Size(max = 60, min = 2, message = "A descrição deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String descricao;

	private boolean cobertura;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a umidade do local")
	@Size(max = 60, min = 2, message = "A umidade deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String umidade;
	
	private byte[] fotos;
	
	@OneToMany(mappedBy = "local")
	private List<Verdinha> verdinhas;

}
