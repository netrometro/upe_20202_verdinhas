package com.example.catalogo.model.enuns;

public enum TipoPodaLimpeza {

	DRASTICA(0, "DRASTICA"), 
	FOLHA_SECA(1, "FOLHA_SECA"),
	BELISCAO(2, "BELISCAO"), 
	JARDINEIRA(3, "JARDINEIRA"),
	FLORACAO(4, "FLORACAO"), 
	CIRCULAR(5, "CIRCULAR"); 
	
	private Integer cod;
	private String descricao;

	private TipoPodaLimpeza(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPodaLimpeza toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoPodaLimpeza x : TipoPodaLimpeza.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de poda limpeza inválida!" + cod);
		
	}
	
}
