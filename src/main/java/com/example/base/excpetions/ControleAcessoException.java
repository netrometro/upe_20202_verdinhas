package com.example.base.excpetions;

public class ControleAcessoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	ControleAcessoException() {
		super();
	}
	
	public ControleAcessoException(String msg) {
		super(msg);
	}
	
	public ControleAcessoException(String msg, Throwable ex) {
		super(msg, ex);
	}
	
	public ControleAcessoException(Throwable ex) {
		super(ex);
	}
}
