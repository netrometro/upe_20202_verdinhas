package com.example.catalogo.model.enuns;

public enum TipoIncidenciaSolar {

	DIRETA(0, "DIRETA"), 
	INDIRETA(1, "INDIRETA"); 
	
	private Integer cod;
	private String descricao;

	private TipoIncidenciaSolar(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoIncidenciaSolar toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoIncidenciaSolar x : TipoIncidenciaSolar.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de incidencia solar inválida!" + cod);
		
	}
	
}
