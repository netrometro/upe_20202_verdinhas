package com.example.base;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public abstract class GenericEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private LocalDateTime dataInclusao = LocalDateTime.now();

	private LocalDateTime dataUltimaAlteracao;
	
}
