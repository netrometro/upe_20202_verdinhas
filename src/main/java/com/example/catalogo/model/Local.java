package com.example.catalogo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.base.GenericEntity;
import com.example.catalogo.model.enuns.TipoExposicaoSolar;
import com.example.catalogo.model.enuns.TipoIncidenciaSolar;
import com.example.catalogo.model.enuns.TipoVento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "verdinhas_local")
@EqualsAndHashCode(callSuper = false)
public class Local extends GenericEntity {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_local")
	private Long id;

	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe o nome do local")
	@NotNull
	@Size(max = 60, min = 2, message = "O nome do local deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String nome;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a descrição do local")
	@NotNull
	@Size(max = 60, min = 2, message = "A descrição deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String descricao;

	private boolean cobertura;
	
	@Column(length = 60, nullable = false)
	@NotBlank(message = "Informe a umidade do local")
	@NotNull
	@Size(max = 60, min = 2, message = "A umidade deve ter no máximo {max} 60 caracteres e no mínimo {min} 10 caracteres")
	private String umidade;
	
	private byte[] fotos;
	
	@OneToMany(mappedBy = "local")
	private List<Verdinha> verdinhas;

	@Enumerated(EnumType.STRING)
	private TipoIncidenciaSolar incidenciaSolar;
	
	@Enumerated(EnumType.STRING)
	private TipoExposicaoSolar exposicaoSolar;
	
	@Enumerated(EnumType.STRING)
	private TipoVento vento;
	
}
