package com.example.insumos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insumos.dao.IVasoDAO;
import com.example.insumos.model.Vaso;
import com.example.insumos.services.dao.IVasoCRUDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VasoCRUDService implements IVasoCRUDService {

	@Autowired
	private IVasoDAO Vasos;

	public List<Vaso> fetchAll() {
		log.info("Retorna os vasos da base de dados");
		return Vasos.findAll();
	}

	public Vaso fetch(Long vasoID) {
		log.info("Retorna um vaso específico da base de dados");
		Optional<Vaso> foundVasos = Vasos.findById(vasoID);
		if (!foundVasos.isPresent()) {
			log.info("Vaso não encontrada na base de dados");
			return null;
		}
		return foundVasos.get();
	}

	public Vaso create(Vaso vaso) {
		log.info("Vaso cadastrado na base de dados");
		return Vasos.save(vaso);
	}

	public Vaso update(Long vasoID, Vaso vaso) {
		log.info("Vaso atualizado na base de dados");
		Optional<Vaso> foundVaso = Vasos.findById(vasoID);
		if (!foundVaso.isPresent()) {
			log.info("Vaso não encontrado na base de dados");
			return null;
		}
		return Vasos.save(foundVaso.get().setId(vasoID));
	}

	public Vaso delete(Long vasoID) {
		log.info("Vaso deletado da base de dados");
		Optional<Vaso> foundVaso = Vasos.findById(vasoID);
		if (!foundVaso.isPresent()) {
			log.info("Vaso não encontrado na base de dados");
			return null;
		}

		Vasos.delete(foundVaso.get());
		return foundVaso.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IVasoDAO getDao() {
		return Vasos;
	}

}
