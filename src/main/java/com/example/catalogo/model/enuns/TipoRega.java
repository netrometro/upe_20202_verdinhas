package com.example.catalogo.model.enuns;

public enum TipoRega {

	ABUNDANTE(0, "ABUNDANTE"), 
	MODERADA(1, "MODERADA"),
	PULVERIZACAO(2, "PULVERIZACAO"), 
	GOTEJAMENTO(3, "GOTEJAMENTO"),
	SUBSTRATO_UMIDO(4, "SUBSTRATO_UMIDO");
	
	private Integer cod;
	private String descricao;

	private TipoRega(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoRega toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoRega x : TipoRega.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de regação inválida!" + cod);
		
	}
	
}
