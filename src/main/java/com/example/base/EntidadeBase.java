package com.example.base;

import java.time.LocalDateTime;

import javax.persistence.Column;

//import java.time.LocalDateTime;

//import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public class EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime dataInclusao;

	@Column(nullable = false)
	private LocalDateTime dataUltimaAlteracao;
	
}
