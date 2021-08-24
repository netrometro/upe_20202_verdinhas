package com.example.catalogo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.base.interfaces.ICaracteristicasCRUDService;
import com.example.catalogo.dao.ICaracteristicasDAO;
import com.example.catalogo.model.Caracteristicas;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CaracteristicasCRUDService implements ICaracteristicasCRUDService {

	@Autowired
	private ICaracteristicasDAO caracteristicasDAO;
	
	public List<Caracteristicas> fetchAll() {
		log.info("Retorna as caracteristicas da base de dados");
		return caracteristicasDAO.findAll();
	}
	
	public Caracteristicas fetch(Long caracteristicaID) {
		log.info("Retorna uma caracteristica específica da base de dados");
		Optional<Caracteristicas> foundCaracteristica = caracteristicasDAO.findById(caracteristicaID);
		if (!foundCaracteristica.isPresent()) {
			log.info("Caracteristica não encontrada na base de dados");
			return null;
		}
		return foundCaracteristica.get();
	}
	
	public Caracteristicas create(Caracteristicas caracteristicas) {
		log.info("Caracteristica cadastrada na base de dados");
		return caracteristicasDAO.save(caracteristicas);
	}
	
	public Caracteristicas update(Long caracteristicaID, Caracteristicas caracteristicas) {
		log.info("Caracteristica atualizada na base de dados");
		Optional<Caracteristicas> foundCaracteristica = caracteristicasDAO.findById(caracteristicaID);
		if (!foundCaracteristica.isPresent()) {
			log.info("Caracteristica não encontrada na base de dados");
			return null;
		}
		return caracteristicasDAO.save(foundCaracteristica.get().setId(caracteristicaID));
	}
	
	public Caracteristicas delete(Long caracteristicaID) {
		log.info("Caracteristica deletada da base de dados");
		Optional<Caracteristicas> foundCaracteristica = caracteristicasDAO.findById(caracteristicaID);
		if (!foundCaracteristica.isPresent()) {
			log.info("Caracteristica não encontrada na base de dados");
			return null;
		}
		
		caracteristicasDAO.delete(foundCaracteristica.get());
		return foundCaracteristica.get();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ICaracteristicasDAO getDao() {
		return caracteristicasDAO;
	}
	
}
