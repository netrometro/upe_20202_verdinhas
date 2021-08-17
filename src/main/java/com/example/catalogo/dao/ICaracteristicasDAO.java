package com.example.catalogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Caracteristicas;

@Component
@Repository
public interface ICaracteristicasDAO extends JpaRepository<Caracteristicas, Long> {

}
