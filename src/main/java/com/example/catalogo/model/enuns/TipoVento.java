package com.example.catalogo.model.enuns;

public enum TipoVento {

	DIRETA(0, "DIRETA"), 
	INDIRETA(1, "INDIRETA"),
	INDIFERENTE(2, "INDIFERENTE"), 
	SEM_VENTO(3, "SEM_VENTO");
	
	private Integer cod;
	private String descricao;

	private TipoVento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoVento toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoVento x : TipoVento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de vaso inválida!" + cod);
		
	}
	
}
