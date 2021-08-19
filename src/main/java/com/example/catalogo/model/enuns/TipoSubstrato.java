package com.example.catalogo.model.enuns;

public enum TipoSubstrato {

	ARENOSO(0, "ARENOSO"), 
	PEDRA(1, "PEDRA"),
	MISTO(2, "MISTO"), 
	CASCA_PINUS(3, "CASCA_PINUS"),
	ESFAGNO(4, "ESFAGNO");
	
	private Integer cod;
	private String descricao;

	private TipoSubstrato(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoSubstrato toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoSubstrato x : TipoSubstrato.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de subtrato inválida!" + cod);
		
	}
	
}
