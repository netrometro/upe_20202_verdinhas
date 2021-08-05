package com.example.catalogo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Necessidades;

@Repository
public interface INecessidadesDAO extends CrudRepository<Necessidades, Long> {

}
