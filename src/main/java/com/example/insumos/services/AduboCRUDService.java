package com.example.insumos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insumos.dao.IAduboDAO;
import com.example.insumos.model.Adubo;
import com.example.insumos.services.dao.IAduboCRUDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AduboCRUDService implements IAduboCRUDService {

	@Autowired
	private IAduboDAO Adubos;

	public List<Adubo> fetchAll() {
		log.info("Retorna os adubos da base de dados");
		return Adubos.findAll();
	}

	public Adubo fetch(Long aduboID) {
		log.info("Retorna um adubo específico da base de dados");
		Optional<Adubo> foundAdubos = Adubos.findById(aduboID);
		if (!foundAdubos.isPresent()) {
			log.info("Adubo não encontrada na base de dados");
			return null;
		}
		return foundAdubos.get();
	}

	public Adubo create(Adubo adubo) {
		log.info("Adubo cadastrada na base de dados");
		return Adubos.save(adubo);
	}

	public Adubo update(Long aduboID, Adubo adubo) {
		log.info("Adubo atualizado na base de dados");
		Optional<Adubo> foundAdubo = Adubos.findById(aduboID);
		if (!foundAdubo.isPresent()) {
			log.info("Adubo não encontrado na base de dados");
			return null;
		}
		return Adubos.save(foundAdubo.get().setId(aduboID));
	}

	public Adubo delete(Long aduboID) {
		log.info("Adubo deletado da base de dados");
		Optional<Adubo> foundAdubo = Adubos.findById(aduboID);
		if (!foundAdubo.isPresent()) {
			log.info("Adubo não encontrado na base de dados");
			return null;
		}

		Adubos.delete(foundAdubo.get());
		return foundAdubo.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IAduboDAO getDao() {
		return Adubos;
	}

}
