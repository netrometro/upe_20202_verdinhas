package com.example.catalogo.model.enuns;

public enum TipoPropagacao {

	ESTAQUIA(0, "ESTAQUIA"), 
	SEMENTE(1, "SEMENTE");
	
	private Integer cod;
	private String descricao;

	private TipoPropagacao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoPropagacao toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoPropagacao x : TipoPropagacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de propagação inválida!" + cod);
		
	}
	
}
