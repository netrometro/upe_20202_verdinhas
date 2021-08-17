package com.example.insumos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tratamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_tratamento")
	private Long id;

	private String nome;
	private String composicao;
	private String tipoPatologia;
	private byte[] fotos;
	private Integer quantidade;
	private String observacao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	
	public byte[] getFotos() {
		return fotos;
	}
	
	public void setFotos(byte[] fotos) {
		this.fotos = fotos;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getComposicao() {
		return composicao;
	}
	
	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}
	
	public String getTipoPatologia() {
		return tipoPatologia;
	}
	
	public void setTipoPatologia(String tipoPatologia) {
		this.tipoPatologia = tipoPatologia;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
