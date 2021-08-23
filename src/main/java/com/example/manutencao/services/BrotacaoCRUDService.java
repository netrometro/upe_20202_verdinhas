package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IBrotacaoDAO;
import com.example.manutencao.model.Brotacao;
import com.example.manutencao.services.dao.IBrotacaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BrotacaoCRUDService implements IBrotacaoService {

	@Autowired
	private IBrotacaoDAO Brotacoes;

	public List<Brotacao> fetchAll() {
		log.info("Retorna as brotações da base de dados.");
		return Brotacoes.findAll();
	}

	public Brotacao fetch(Long brotacaoID) {
		log.info("Retorna uma brotação da base de dados.");
		Optional<Brotacao> foundBrotacao = Brotacoes.findById(brotacaoID);
		if (!foundBrotacao.isPresent()) {
			log.info("Brotação não encontrada na base de dados.");
			return null;
		}
		return foundBrotacao.get();
	}

	public Brotacao create(Brotacao brotacao) {
		log.info("Brotação cadastrada na base de dados.");
		return Brotacoes.save(brotacao);
	}
	
	public Brotacao update(Long brotacaoID, Brotacao brotacao) {
		log.info("Brotação atualizada na base de dados.");
		Optional<Brotacao> foundBrotacao = Brotacoes.findById(brotacaoID);
		if (!foundBrotacao.isPresent()) {
			log.info("Brotação não encontrada na base de dados.");
			return null;
		}
		return Brotacoes.save(foundBrotacao.get().setId(brotacaoID));
	}

	public Brotacao delete(Long brotacaoID) {
		log.info("Brotação excluída da base de dados.");
		Optional<Brotacao> foundBrotacao = Brotacoes.findById(brotacaoID);
		if (!foundBrotacao.isPresent()) {
			log.info("Brotação não encontrada na base de dados.");
			return null;
		}
		
		Brotacoes.delete(foundBrotacao.get());
		return foundBrotacao.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IBrotacaoDAO getDao() {
		return Brotacoes;
	}
	
}
