package com.ninatompkin.driverslicense.services;

import java.util.Optional;

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
	
	public void createLicense(License license) {
		licenseRepo.save(license);
		Long id = license.getId();
        License thisLicense = licenseRepo.findById(id)
        thisLicense.setNumber(String.format("%06d", license.getId()));
        licenseRepo.save(thisLicense);
	}
	
	public void joinPerson(License license, Person person) {
		license.setPerson(person);
		licenseRepo.save(license);
	}

}
