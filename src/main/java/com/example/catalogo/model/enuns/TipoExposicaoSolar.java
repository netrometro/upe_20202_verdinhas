package com.example.catalogo.model.enuns;

public enum TipoExposicaoSolar {

	UmH_DIA(0, "UMA_HORA_POR_DIA"), 
	DoisH_DIA(1, "DUAS_HORAS_POR_DIA"), 
	TresH_DIA(2, "TRES_HORAS_POR_DIA"),
	QuatroH_DIA(3, "QUATRO_HORAS_POR_DIA"), 
	SOL_MANHA(4, "SOL_MANHA"), 
	UmH_SOL_MANHA(5, "UMA_HORA_SOL_MANHA"),
	DoisH_SOL_MANHA(6, "DOIS_HORAS_SOL_MANHA"), 
	QuatroH_SOL_MANHA(7, "QUATRO_HORAS_SOL_MANHA"),
	SOL_TARDE(8, "SOL_TARDE"), 
	UmH_SOL_TARDE(9, "UMA_HORA_SOL_TARDE"), 
	DoisH_SOL_TARDE(10, "DOIS_HORAS_SOL_TARDE"),
	TresH_SOL_TARDE(11, "TRES_HORAS_SOL_TARDE");

	private Integer cod;
	private String descricao;

	private TipoExposicaoSolar(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoExposicaoSolar toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoExposicaoSolar x : TipoExposicaoSolar.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de exposição inválida!" + cod);
		
	}
	
}
