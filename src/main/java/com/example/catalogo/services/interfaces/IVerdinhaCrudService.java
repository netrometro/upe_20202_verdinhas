package com.example.catalogo.services.interfaces;

import java.util.Collection;

import com.example.catalogo.model.Verdinha;

public interface IVerdinhaCRUDService {
	
	public abstract void create(Verdinha verdinha);
	public abstract void update(Long id, Verdinha verdinha);
	public abstract void delete(Long id);
	public abstract Collection<Verdinha> getVerdinhas();
	
}
