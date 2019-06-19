package com.ninatompkin.countries.services;

import org.springframework.stereotype.Service;

import com.ninatompkin.countries.repositories.CountryRepository;

@Service
public class ApiService {
	private final CountryRepository countryRepo;
	
	public ApiService(CountryRepository countryRepo) {
		this.countryRepo = countryRepo;
	}

}
