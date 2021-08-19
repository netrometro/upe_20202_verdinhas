package com.example.catalogo.model.enuns;

public enum TipoVaso {

	PLASTICO(0, "PLASTICO"), 
	BARRO(1, "BARRO"),
	MADEIRA(2, "MADEIRA"), 
	JARDINEIRA(3, "JARDINEIRA"),
	SOLO(4, "SOLO"),
	CAQUEIRA(5, "CAQUEIRA"),
	CASCA_COCO(6, "CASCA_COCO");
	
	private Integer cod;
	private String descricao;

	private TipoVaso(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoVaso toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoVaso x : TipoVaso.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de vaso inválida!" + cod);
		
	}
	
}
