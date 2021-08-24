package com.example.insumos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insumos.dao.ISubstratoDAO;
import com.example.insumos.model.Substrato;
import com.example.insumos.services.dao.ISubstratoCRUDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubstratoCRUDService implements ISubstratoCRUDService {

	@Autowired
	private ISubstratoDAO Substratos;

	public List<Substrato> fetchAll() {
		log.info("Retorna os substratos da base de dados");
		return Substratos.findAll();
	}

	public Substrato fetch(Long substratoID) {
		log.info("Retorna um substrato específico da base de dados");
		Optional<Substrato> foundSubstratos = Substratos.findById(substratoID);
		if (!foundSubstratos.isPresent()) {
			log.info("Substrato não encontrada na base de dados");
			return null;
		}
		return foundSubstratos.get();
	}

	public Substrato create(Substrato substrato) {
		log.info("Substrato cadastrado na base de dados");
		return Substratos.save(substrato);
	}

	public Substrato update(Long substratoID, Substrato substrato) {
		log.info("Substrato atualizado na base de dados");
		Optional<Substrato> foundSubstrato = Substratos.findById(substratoID);
		if (!foundSubstrato.isPresent()) {
			log.info("Substrato não encontrado na base de dados");
			return null;
		}
		return Substratos.save(foundSubstrato.get().setId(substratoID));
	}

	public Substrato delete(Long substratoID) {
		log.info("Substrato deletado da base de dados");
		Optional<Substrato> foundSubstrato = Substratos.findById(substratoID);
		if (!foundSubstrato.isPresent()) {
			log.info("Substrato não encontrado na base de dados");
			return null;
		}

		Substratos.delete(foundSubstrato.get());
		return foundSubstrato.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ISubstratoDAO getDao() {
		return Substratos;
	}

}
