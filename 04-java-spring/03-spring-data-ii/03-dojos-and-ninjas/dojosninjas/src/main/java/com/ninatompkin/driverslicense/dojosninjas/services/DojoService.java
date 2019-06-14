package com.ninatompkin.driverslicense.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.driverslicense.dojosninjas.models.Dojo;
import com.ninatompkin.driverslicense.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	//Return all Dojos
	public List<Dojo> findAll(){
		return dojoRepo.findAll();
	}
	
	//Return one Dojo
	public Dojo findOne(Long id) {
		return dojoRepo.findById(id).orElse(null);
	}
	
	//Create a dojo
	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
	
}
