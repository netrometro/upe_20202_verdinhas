package com.example.catalogo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Caracteristicas;


@Repository
public interface ICaracteristicasDAO extends CrudRepository<Caracteristicas, Long> {

}
