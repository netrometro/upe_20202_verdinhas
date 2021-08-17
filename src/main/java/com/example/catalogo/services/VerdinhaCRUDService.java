package com.example.catalogo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.catalogo.dao.IVerdinhaDAO;
import com.example.catalogo.services.interfaces.IVerdinhaCRUDService;

@Service
public class VerdinhaCRUDService implements IVerdinhaCRUDService{

	@Autowired
	private IVerdinhaDAO dao;
	
	@SuppressWarnings("unchecked")
	@Override
	public IVerdinhaDAO getDao() {
		return dao;
	}

}
