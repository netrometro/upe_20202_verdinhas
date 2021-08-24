package com.example.insumos.model;

import java.util.ArrayList;
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
import com.example.insumos.model.enuns.TipoAdubo;
import com.example.manutencao.model.Manutencao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "adubo")
@EqualsAndHashCode(callSuper = false)
public class Adubo extends GenericEntity {
	private static final long serialVersionUID = 1L;
	
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
	
	@OneToMany(mappedBy = "adubo")
	private List<Manutencao> manutencoes = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private TipoAdubo tipoAdubo;
	
}


