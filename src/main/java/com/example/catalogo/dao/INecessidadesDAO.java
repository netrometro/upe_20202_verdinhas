package com.example.catalogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Necessidades;

@Component
@Repository
public interface INecessidadesDAO extends JpaRepository<Necessidades, Long> {

}
