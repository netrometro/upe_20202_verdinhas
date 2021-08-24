package com.example.manutencao.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manutencao.dao.ILembreteDAO;
import com.example.manutencao.model.Lembrete;
import com.example.manutencao.services.dao.ILembreteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LembreteCRUDService implements ILembreteService {

	@Autowired
	private ILembreteDAO Lembretes;

	public List<Lembrete> fetchAll() {
		log.info("Retorna os lembretes da base de dados.");
		return Lembretes.findAll();
	}

	public Lembrete fetch(Long lembreteID) {
		log.info("Retorna um lembrete da base de dados.");
		Optional<Lembrete> foundLembrete = Lembretes.findById(lembreteID);
		if (!foundLembrete.isPresent()) {
			log.info("Lembrete não encontrada na base de dados.");
			return null;
		}
		return foundLembrete.get();
	}

	public Lembrete create(Lembrete lembrete) {
		log.info("Lembrete cadastrado na base de dados.");
		return Lembretes.save(lembrete);
	}

	public Lembrete update(Long lembreteID, Lembrete lembrete) {
		log.info("Lembrete atualizado na base de dados.");
		Optional<Lembrete> foundLembrete = Lembretes.findById(lembreteID);
		if (!foundLembrete.isPresent()) {
			log.info("Lembrete não encontrada na base de dados.");
			return null;
		}
		return Lembretes.save(foundLembrete.get().setId(lembreteID));
	}

	public Lembrete delete(Long lembreteID) {
		log.info("Lembrete excluído da base de dados.");
		Optional<Lembrete> foundLembrete = Lembretes.findById(lembreteID);
		if (!foundLembrete.isPresent()) {
			log.info("Lembrete não encontrado na base de dados.");
			return null;
		}

		Lembretes.delete(foundLembrete.get());
		return foundLembrete.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ILembreteDAO getDao() {
		return Lembretes;
	}

}
