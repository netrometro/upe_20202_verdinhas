package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IFloracaoDAO;
import com.example.manutencao.model.Floracao;
import com.example.manutencao.services.dao.IFloracaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FloracaoCRUDService implements IFloracaoService {

	@Autowired
	private IFloracaoDAO Floracoes;

	public List<Floracao> fetchAll() {
		log.info("Retorna as florações da base de dados.");
		return Floracoes.findAll();
	}

	public Floracao fetch(Long floracaoID) {
		log.info("Retorna uma floração da base de dados.");
		Optional<Floracao> foundFloracao = Floracoes.findById(floracaoID);
		if (!foundFloracao.isPresent()) {
			log.info("Floração não encontrada na base de dados.");
			return null;
		}
		return foundFloracao.get();
	}

	public Floracao create(Floracao floracao) {
		log.info("Floração cadastrada na base de dados.");
		return Floracoes.save(floracao);
	}

	public Floracao update(Long floracaoID, Floracao floracao) {
		log.info("Floração atualizado na base de dados.");
		Optional<Floracao> foundFloracao = Floracoes.findById(floracaoID);
		if (!foundFloracao.isPresent()) {
			log.info("Floração não encontrada na base de dados.");
			return null;
		}
		return Floracoes.save(foundFloracao.get().setId(floracaoID));
	}

	public Floracao delete(Long floracaoID) {
		log.info("Floração excluída da base de dados.");
		Optional<Floracao> foundFloracao = Floracoes.findById(floracaoID);
		if (!foundFloracao.isPresent()) {
			log.info("Floracao não encontrada na base de dados.");
			return null;
		}

		Floracoes.delete(foundFloracao.get());
		return foundFloracao.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IFloracaoDAO getDao() {
		return Floracoes;
	}

}
