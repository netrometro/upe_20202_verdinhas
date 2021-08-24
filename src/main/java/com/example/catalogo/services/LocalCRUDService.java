package com.example.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.interfaces.ILocalCRUDService;
import com.example.catalogo.dao.ILocalDAO;
import com.example.catalogo.model.Local;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LocalCRUDService implements ILocalCRUDService {

	@Autowired
	private ILocalDAO Locais;
	
	public List<Local> fetchAll() {
		log.info("Retorna os locais da base de dados");
		return Locais.findAll();
	}
	
	public Local fetch(Long localID) {
		log.info("Retorna um local específico da base de dados");
		Optional<Local> foundLocal = Locais.findById(localID);
		if (!foundLocal.isPresent()) {
			log.info("Local não encontrado na base de dados");
			return null;
		}
		return foundLocal.get();
	}
	
	public Local create(Local local) {
		log.info("Local cadastrado na base de dados");
		return Locais.save(local);
	}
	
	public Local update(Long localID, Local local) {
		log.info("Local atualizado na base de dados");
		Optional<Local> foundLocal = Locais.findById(localID);
		if (!foundLocal.isPresent()) {
			log.info("Local não encontrada na base de dados");
			return null;
		}
		return Locais.save(foundLocal.get().setId(localID));
	}
	
	public Local delete(Long localID) {
		log.info("Local deletado da base de dados");
		Optional<Local> foundLocal = Locais.findById(localID);
		if (!foundLocal.isPresent()) {
			log.info("Local não encontrada na base de dados");
			return null;
		}
		
		Locais.delete(foundLocal.get());
		return foundLocal.get();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ILocalDAO getDao() {
		return Locais;
	}
	
}
