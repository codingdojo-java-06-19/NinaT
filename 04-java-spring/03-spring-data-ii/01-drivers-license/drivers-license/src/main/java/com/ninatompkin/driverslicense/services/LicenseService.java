package com.ninatompkin.driverslicense.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.driverslicense.models.License;
import com.ninatompkin.driverslicense.models.Person;
import com.ninatompkin.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licenseRepo;
	
	public LicenseService(LicenseRepository licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	//Retrieving all licenses
	public List<License> findAll(){
		return licenseRepo.findAll();
	}
	
	//Retrieve a single license
	public void createLicense(License license) {
		Long number = licenseRepo.count();
		license.setNumber(String.format("%06d",  number));
		licenseRepo.save(license);
	}
	
	//Return a single license
	public License findById(Long id) {
		return licenseRepo.findById(id).orElse(null);
	}
	

	public void joinPerson(License license, Person person) {
		license.setPerson(person);
		licenseRepo.save(license);
	}

}
