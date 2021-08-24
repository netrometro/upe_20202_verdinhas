package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IManutencaoDAO;
import com.example.manutencao.model.Manutencao;
import com.example.manutencao.services.dao.IManutencaoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ManutencaoCRUDService implements IManutencaoService {

	@Autowired
	private IManutencaoDAO Manutencoes;

	public List<Manutencao> fetchAll() {
		log.info("Retorna as manutenções da base de dados.");
		return Manutencoes.findAll();
	}

	public Manutencao fetch(Long manutencaoID) {
		log.info("Retorna uma manutenção da base de dados.");
		Optional<Manutencao> foundManutencao = Manutencoes.findById(manutencaoID);
		if (!foundManutencao.isPresent()) {
			log.info("Manutenção não encontrada na base de dados.");
			return null;
		}
		return foundManutencao.get();
	}

	public Manutencao create(Manutencao manutencao) {
		log.info("Manutenção cadastrada na base de dados.");
		return Manutencoes.save(manutencao);
	}

	public Manutencao update(Long manutencaoID, Manutencao manutencao) {
		log.info("Manutenção atualizado na base de dados.");
		Optional<Manutencao> foundManutencao = Manutencoes.findById(manutencaoID);
		if (!foundManutencao.isPresent()) {
			log.info("Manutenção não encontrada na base de dados.");
			return null;
		}
		return Manutencoes.save(foundManutencao.get().setId(manutencaoID));
	}

	public Manutencao delete(Long manutencaoID) {
		log.info("Manutenção excluída da base de dados.");
		Optional<Manutencao> foundManutencao = Manutencoes.findById(manutencaoID);
		if (!foundManutencao.isPresent()) {
			log.info("Manutenção não encontrada na base de dados.");
			return null;
		}

		Manutencoes.delete(foundManutencao.get());
		return foundManutencao.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IManutencaoDAO getDao() {
		return Manutencoes;
	}

}
