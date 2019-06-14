package com.ninatompkin.driverslicense.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.driverslicense.dojosninjas.models.Ninja;
import com.ninatompkin.driverslicense.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	//Return all Ninjas
	public List<Ninja> findAllNinjas(){
		return ninjaRepo.findAll();
	}
	
	//Return one Ninja
	public Ninja findNinja(Long id) {
		return ninjaRepo.findById(id).orElse(null);
	}
	
	//Create a Ninja
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}


}
