package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IFrutificacaoDAO;
import com.example.manutencao.model.Frutificacao;
import com.example.manutencao.services.dao.IFrutificacaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FrutificacaoCRUDService implements IFrutificacaoService {

	@Autowired
	private IFrutificacaoDAO Frutificacoes;

	public List<Frutificacao> fetchAll() {
		log.info("Retorna as frutificações da base de dados.");
		return Frutificacoes.findAll();
	}

	public Frutificacao fetch(Long frutificacaoID) {
		log.info("Retorna uma frutificação da base de dados.");
		Optional<Frutificacao> foundFrutificacao = Frutificacoes.findById(frutificacaoID);
		if (!foundFrutificacao.isPresent()) {
			log.info("Frutificação não encontrada na base de dados.");
			return null;
		}
		return foundFrutificacao.get();
	}

	public Frutificacao create(Frutificacao frutificacao) {
		log.info("Frutificação cadastrada na base de dados.");
		return Frutificacoes.save(frutificacao);
	}

	public Frutificacao update(Long frutificacaoID, Frutificacao frutificacao) {
		log.info("Frutificação atualizado na base de dados.");
		Optional<Frutificacao> foundFrutificacao = Frutificacoes.findById(frutificacaoID);
		if (!foundFrutificacao.isPresent()) {
			log.info("Frutificação não encontrada na base de dados.");
			return null;
		}
		return Frutificacoes.save(foundFrutificacao.get().setId(frutificacaoID));
	}

	public Frutificacao delete(Long frutificacaoID) {
		log.info("Frutificação excluída da base de dados.");
		Optional<Frutificacao> foundFrutificacao = Frutificacoes.findById(frutificacaoID);
		if (!foundFrutificacao.isPresent()) {
			log.info("Frutificação não encontrada na base de dados.");
			return null;
		}

		Frutificacoes.delete(foundFrutificacao.get());
		return foundFrutificacao.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IFrutificacaoDAO getDao() {
		return Frutificacoes;
	}

}
