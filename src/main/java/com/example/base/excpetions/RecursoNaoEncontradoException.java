package com.example.base.excpetions;

public class RecursoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 491532513940663615L;

	public RecursoNaoEncontradoException(String msg) {
		super(msg);
	}
	
}
