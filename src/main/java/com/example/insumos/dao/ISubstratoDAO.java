package com.example.insumos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.insumos.model.Substrato;

@Component
@Repository
public interface ISubstratoDAO extends JpaRepository<Substrato, Long>{

}
