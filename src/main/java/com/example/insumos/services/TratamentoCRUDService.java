package com.example.insumos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.insumos.dao.ITratamentoDAO;
import com.example.insumos.model.Tratamento;
import com.example.insumos.services.dao.ITratamentoCRUDService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TratamentoCRUDService implements ITratamentoCRUDService {

	@Autowired
	private ITratamentoDAO Tratamentos;

	public List<Tratamento> fetchAll() {
		log.info("Retorna os tratamentos da base de dados");
		return Tratamentos.findAll();
	}

	public Tratamento fetch(Long tratamentoID) {
		log.info("Retorna um tratamento específico da base de dados");
		Optional<Tratamento> foundTratamento = Tratamentos.findById(tratamentoID);
		if (!foundTratamento.isPresent()) {
			log.info("Tratamento não encontrada na base de dados");
			return null;
		}
		return foundTratamento.get();
	}

	public Tratamento create(Tratamento tratamento) {
		log.info("Tratamento cadastrado na base de dados");
		return Tratamentos.save(tratamento);
	}

	public Tratamento update(Long tratamentoID, Tratamento tratamento) {
		log.info("Tratamento atualizado na base de dados");
		Optional<Tratamento> foundTratamento = Tratamentos.findById(tratamentoID);
		if (!foundTratamento.isPresent()) {
			log.info("Tratamento não encontrado na base de dados");
			return null;
		}
		return Tratamentos.save(foundTratamento.get().setId(tratamentoID));
	}

	public Tratamento delete(Long tratamentoID) {
		log.info("Tratamento deletado da base de dados");
		Optional<Tratamento> foundTratamento = Tratamentos.findById(tratamentoID);
		if (!foundTratamento.isPresent()) {
			log.info("Tratamento não encontrado na base de dados");
			return null;
		}

		Tratamentos.delete(foundTratamento.get());
		return foundTratamento.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ITratamentoDAO getDao() {
		return Tratamentos;
	}

}
