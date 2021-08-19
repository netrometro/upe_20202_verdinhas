package com.example.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.interfaces.IVerdinhaCRUDService;
import com.example.catalogo.dao.IVerdinhaDAO;
import com.example.catalogo.model.Verdinha;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VerdinhaCRUDService implements IVerdinhaCRUDService {

	@Autowired
	private IVerdinhaDAO Verdinhas;
	
	public List<Verdinha> fetchAll() {
		log.info("Retorna as verdinhas da base de dados");
		return Verdinhas.findAll();
	}
	
	public Verdinha fetch(Long verdinhaID) {
		log.info("Retorna uma verdinha específica da base de dados");
		Optional<Verdinha> foundVerdinhas = Verdinhas.findById(verdinhaID);
		if (!foundVerdinhas.isPresent()) {
			log.info("Verdinha não encontrada na base de dados");
			return null;
		}
		return foundVerdinhas.get();
	}
	
	public Verdinha create(Verdinha verdinha) {
		log.info("Verdinha cadastrada na base de dados");
		return Verdinhas.save(verdinha);
	}
	
	public Verdinha update(Long verdinhaID, Verdinha verdinha) {
		log.info("Verdinha atualizada na base de dados");
		Optional<Verdinha> foundVerdinhas = Verdinhas.findById(verdinhaID);
		if (!foundVerdinhas.isPresent()) {
			log.info("Verdinha não encontrada na base de dados");
			return null;
		}
		return Verdinhas.save(foundVerdinhas.get().setId(verdinhaID));
	}
	
	public Verdinha delete(Long verdinhaID) {
		log.info("Verdinha deletada da base de dados");
		Optional<Verdinha> foundVerdinhas = Verdinhas.findById(verdinhaID);
		if (!foundVerdinhas.isPresent()) {
			log.info("Verdinha não encontrada na base de dados");
			return null;
		}
		
		Verdinhas.delete(foundVerdinhas.get());
		return foundVerdinhas.get();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IVerdinhaDAO getDao() {
		return Verdinhas;
	}
	
}
