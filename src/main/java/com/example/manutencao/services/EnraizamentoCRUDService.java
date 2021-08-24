package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IEnraizamentoDAO;
import com.example.manutencao.model.Enraizamento;
import com.example.manutencao.services.dao.IEnraizamentoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EnraizamentoCRUDService implements IEnraizamentoService {

	@Autowired
	private IEnraizamentoDAO Enraizamentos;

	public List<Enraizamento> fetchAll() {
		log.info("Retorna os enraizamentos da base de dados.");
		return Enraizamentos.findAll();
	}

	public Enraizamento fetch(Long enraizamentoID) {
		log.info("Retorna um enraizamento da base de dados.");
		Optional<Enraizamento> foundEnraizamento = Enraizamentos.findById(enraizamentoID);
		if (!foundEnraizamento.isPresent()) {
			log.info("Enraizamento não encontrada na base de dados.");
			return null;
		}
		return foundEnraizamento.get();
	}

	public Enraizamento create(Enraizamento enraizamento) {
		log.info("Enraizamento cadastrada na base de dados.");
		return Enraizamentos.save(enraizamento);
	}

	public Enraizamento update(Long enraizamentoID, Enraizamento enraizamento) {
		log.info("Enraizamento atualizado na base de dados.");
		Optional<Enraizamento> foundEnraizamento = Enraizamentos.findById(enraizamentoID);
		if (!foundEnraizamento.isPresent()) {
			log.info("Brotação não encontrada na base de dados.");
			return null;
		}
		return Enraizamentos.save(foundEnraizamento.get().setId(enraizamentoID));
	}

	public Enraizamento delete(Long enraizamentoID) {
		log.info("Enraizamento excluída da base de dados.");
		Optional<Enraizamento> foundEnraizamento = Enraizamentos.findById(enraizamentoID);
		if (!foundEnraizamento.isPresent()) {
			log.info("Enraizamento não encontrada na base de dados.");
			return null;
		}

		Enraizamentos.delete(foundEnraizamento.get());
		return foundEnraizamento.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IEnraizamentoDAO getDao() {
		return Enraizamentos;
	}

}
