package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.IOcorrenciaDAO;
import com.example.manutencao.model.Ocorrencia;
import com.example.manutencao.services.dao.IOcorrenciaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OcorrenciaCRUDService implements IOcorrenciaService {

	@Autowired
	private IOcorrenciaDAO Ocorrencias;

	public List<Ocorrencia> fetchAll() {
		log.info("Retorna as ocorrencias da base de dados.");
		return Ocorrencias.findAll();
	}

	public Ocorrencia fetch(Long ocorrenciaID) {
		log.info("Retorna uma ocorrencia da base de dados.");
		Optional<Ocorrencia> foundOcorrencia = Ocorrencias.findById(ocorrenciaID);
		if (!foundOcorrencia.isPresent()) {
			log.info("Ocorrencia não encontrada na base de dados.");
			return null;
		}
		return foundOcorrencia.get();
	}

	public Ocorrencia create(Ocorrencia ocorrencia) {
		log.info("Ocorrencia cadastrada na base de dados.");
		return Ocorrencias.save(ocorrencia);
	}

	public Ocorrencia update(Long ocorrenciaID, Ocorrencia ocorrencia) {
		log.info("Ocorrencia atualizado na base de dados.");
		Optional<Ocorrencia> foundOcorrencia = Ocorrencias.findById(ocorrenciaID);
		if (!foundOcorrencia.isPresent()) {
			log.info("Ocorrencia não encontrada na base de dados.");
			return null;
		}
		return Ocorrencias.save(foundOcorrencia.get().setId(ocorrenciaID));
	}

	public Ocorrencia delete(Long ocorrenciaID) {
		log.info("Ocorrencia excluída da base de dados.");
		Optional<Ocorrencia> foundOcorrencia = Ocorrencias.findById(ocorrenciaID);
		if (!foundOcorrencia.isPresent()) {
			log.info("Ocorrencia não encontrada na base de dados.");
			return null;
		}

		Ocorrencias.delete(foundOcorrencia.get());
		return foundOcorrencia.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IOcorrenciaDAO getDao() {
		return Ocorrencias;
	}

}
