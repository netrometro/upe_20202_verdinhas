package com.example.insumos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.insumos.model.Adubo;

@Component
@Repository
public interface IAduboDAO extends JpaRepository<Adubo, Long>{

}