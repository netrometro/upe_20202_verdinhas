package com.example.catalogo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Verdinha;

@Repository
public interface IVerdinhaDAO extends CrudRepository<Verdinha, Long> {

}
