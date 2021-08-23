package com.example.manutencao.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.manutencao.model.Lembrete;

@Component
@Repository
public interface ILembreteDAO extends JpaRepository<Lembrete, Long>{

}
