package com.example.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.interfaces.INecessidadesCRUDService;
import com.example.catalogo.dao.INecessidadesDAO;
import com.example.catalogo.model.Necessidades;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NecessidadesCRUDService implements INecessidadesCRUDService {

	@Autowired
	private INecessidadesDAO Necessidade;
	
	public List<Necessidades> fetchAll() {
		log.info("Retorna as necessidades da base de dados");
		return Necessidade.findAll();
	}
	
	public Necessidades fetch(Long necessidadeID) {
		log.info("Retorna uma necessidade específica da base de dados");
		Optional<Necessidades> foundNecessidade = Necessidade.findById(necessidadeID);
		if (!foundNecessidade.isPresent()) {
			log.info("Necessidade não encontrada na base de dados");
			return null;
		}
		return foundNecessidade.get();
	}
	
	public Necessidades create(Necessidades necessidades) {
		Necessidades newNecessidade = new Necessidades();
		return Necessidade.save(newNecessidade);
	}
	
	public Necessidades update(Long necessidadeID, Necessidades necessidades) {
		log.info("Verdinha atualizada na base de dados");
		Optional<Necessidades> foundNecessidade = Necessidade.findById(necessidadeID);
		if (!foundNecessidade.isPresent()) {
			log.info("Necessidade não encontrada na base de dados");
			return null;
		}
		return Necessidade.save(foundNecessidade.get().setId(necessidadeID));
	}
	
	public Necessidades delete(Long necessidadeID) {
		log.info("Necessidade deletada da base de dados");
		Optional<Necessidades> foundNecessidade = Necessidade.findById(necessidadeID);
		if (!foundNecessidade.isPresent()) {
			log.info("Necessidade não encontrada na base de dados");
			return null;
		}
		
		Necessidade.delete(foundNecessidade.get());
		return foundNecessidade.get();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public INecessidadesDAO getDao() {
		return Necessidade;
	}
	
}
