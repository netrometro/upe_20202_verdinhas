package com.example.catalogo.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.catalogo.model.Verdinha;
import com.example.catalogo.services.interfaces.IVerdinhaCRUDService;

@Service
public class VerdinhaCRUDService implements IVerdinhaCRUDService {

	private static Map<Long, Verdinha> verdinhaRepo = new HashMap<>();
	
	@Override
	public void create(Verdinha verdinha) {
		verdinhaRepo.put(verdinha.getId(), verdinha);
	}

	@Override
	public void update(Long id, Verdinha verdinha) {
		verdinhaRepo.remove(id);
		verdinha.setId(id);
		verdinhaRepo.put(id, verdinha);
	}

	@Override
	public void delete(Long id) {
		verdinhaRepo.remove(id);
	}

	@Override
	public Collection<Verdinha> getVerdinhas() {
		return verdinhaRepo.values();
	}

}
