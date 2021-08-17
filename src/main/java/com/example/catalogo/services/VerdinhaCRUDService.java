package com.example.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogo.dao.IVerdinhaDAO;
import com.example.catalogo.model.Verdinha;
import com.example.catalogo.services.interfaces.IVerdinhaCRUDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VerdinhaCRUDService implements IVerdinhaCRUDService {

	@Autowired
	private IVerdinhaDAO iVerdinhaDAO;
	
	public List<Verdinha> fetchAll() {
		log.info("Lista todas as verdinhas do banco de dados.");
		return iVerdinhaDAO.findAll();
	}

	public Verdinha fetch(Long verdinhaId) {
		log.info("Retorna uma verdinha específica do banco de dados.");
		Optional<Verdinha> foundVerdinhas = iVerdinhaDAO.findById(verdinhaId);
		if (!foundVerdinhas.isPresent()) {
			log.info("Verdinha não encontrada na base de dados.");
			return null;
		}
		return foundVerdinhas.get();
	}
	
	public Verdinha create(Verdinha verdinha) {
		log.info("Criando uma nova verdinha.");
		return iVerdinhaDAO.save(verdinha);
	}
	
	public Verdinha update(Long verdinhaId, Verdinha verdinha) {
		log.info("Atualizar uma verdinha específica do banco de dados.");
		Optional<Verdinha> foundVerdinha = iVerdinhaDAO.findById(verdinhaId);
		if (!foundVerdinha.isPresent()) {
			log.info("Verdinha não encontrada no banco de dados.");
			return null;
		}
		return iVerdinhaDAO.save(foundVerdinha.get().setId(verdinhaId));
	}
	
	public Verdinha delete(Long verdinhaId) {
		log.info("Excluir uma verdinha específica do banco de dados.");
		Optional<Verdinha> foundVerdinha = iVerdinhaDAO.findById(verdinhaId);
		if (!foundVerdinha.isPresent()) {
			log.info("Verdinha não encontrada no banco de dados.");
			return null;
		}
		iVerdinhaDAO.delete(foundVerdinha.get());
		return foundVerdinha.get();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public IVerdinhaDAO getDao() {
		return iVerdinhaDAO;
	}
	
}
