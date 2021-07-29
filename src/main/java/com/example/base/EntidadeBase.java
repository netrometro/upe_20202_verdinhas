package com.example.base;

//import java.time.LocalDateTime;

//import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class EntidadeBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/*
	@Column(nullable = false)
	private LocalDateTime dataInclusao;
	
	@Column(nullable = false)
	private LocalDateTime dataUltimaAlteracao;
	*/
}
