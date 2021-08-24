package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IPatologiaDAO;
import com.example.manutencao.model.Patologia;
import com.example.manutencao.services.dao.IPatologiaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatologiaCRUDService implements IPatologiaService {

	@Autowired
	private IPatologiaDAO Patologias;

	public List<Patologia> fetchAll() {
		log.info("Retorna as patologias da base de dados.");
		return Patologias.findAll();
	}

	public Patologia fetch(Long patologiaID) {
		log.info("Retorna uma patologia da base de dados.");
		Optional<Patologia> foundPatologia = Patologias.findById(patologiaID);
		if (!foundPatologia.isPresent()) {
			log.info("Patologia não encontrada na base de dados.");
			return null;
		}
		return foundPatologia.get();
	}

	public Patologia create(Patologia patologia) {
		log.info("Patologia cadastrada na base de dados.");
		return Patologias.save(patologia);
	}

	public Patologia update(Long patologiaID, Patologia patologia) {
		log.info("Patologia atualizado na base de dados.");
		Optional<Patologia> foundPatologia = Patologias.findById(patologiaID);
		if (!foundPatologia.isPresent()) {
			log.info("Patologia não encontrada na base de dados.");
			return null;
		}
		return Patologias.save(foundPatologia.get().setId(patologiaID));
	}

	public Patologia delete(Long patologiaID) {
		log.info("Patologia excluída da base de dados.");
		Optional<Patologia> foundPatologia = Patologias.findById(patologiaID);
		if (!foundPatologia.isPresent()) {
			log.info("Patologia não encontrada na base de dados.");
			return null;
		}

		Patologias.delete(foundPatologia.get());
		return foundPatologia.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPatologiaDAO getDao() {
		return Patologias;
	}

}
