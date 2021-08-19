package com.example.catalogo.model.enuns;

public enum TipoFrequencia {

	DIARIA(0, "DIARIA"), 
	SEMANAL(1, "SEMANAL"), 
	QUINZENAL(2, "QUINZENAL"),
	MENSAL(3, "MENSAL"), 
	SEMESTRAL(4, "SEMESTRAL"), 
	ANUAL(5, "ANUAL"),
	INVERNO(6, "INVERNO"), 
	VERAO(7, "VERAO"),
	UmX_SEMANA(8, "UMA_VEZ_SEMANA"),
	DoisX_SEMANA(9, "DUAS_VEZES_SEMANA"),
	TresX_SEMANA(10, "TRES_VEZES_SEMANA"),
	QuatroX_SEMANA(11, "QUATRO_VEZES_SEMANA");
	
	private Integer cod;
	private String descricao;

	private TipoFrequencia(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoFrequencia toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoFrequencia x : TipoFrequencia.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Tipo de frequencia inválida!" + cod);
		
	}
	
}
