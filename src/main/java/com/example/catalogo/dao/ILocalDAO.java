package com.example.catalogo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.catalogo.model.Local;

@Component
@Repository
public interface ILocalDAO extends JpaRepository<Local, Long> {

}
