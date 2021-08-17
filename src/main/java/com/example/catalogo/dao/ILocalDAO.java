package com.example.catalogo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Local;

@Repository
public interface ILocalDAO extends CrudRepository<Local, Long> {

}
