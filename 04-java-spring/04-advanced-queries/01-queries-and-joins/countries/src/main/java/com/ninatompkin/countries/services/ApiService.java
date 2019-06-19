package com.ninatompkin.countries.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ninatompkin.countries.repositories.CountryRepository;

@Service
public class ApiService {
	private final CountryRepository countryRepo;
	
	public ApiService(CountryRepository countryRepo) {
		this.countryRepo = countryRepo;
	}

	public List<Object[]> query1(){
		System.out.println("This is supposed to display the total number of countries that speak Slovene by percentage, in descending order!");
		return countryRepo.findSloveneSpeakingCountriesByPercentage();
	}
	
	public List<Object[]> query2(){
		System.out.println("This is supposed to display the total nmber of cities for each country!");
		return countryRepo.countCitiesPerCountryDesc();
	}
	
	public List<String> query3(){
		System.out.println("This is supposed to find the biggest cities in Mexico!");
		return countryRepo.findBigCitiesMexicoDesc();
	}
	
	public List<String>query4(){
		return countryRepo.findDominantLanguagesPerCountryDesc();
	}

	public List<String> query5(){
		return countryRepo.findSmallCountriesWithBigPopulations();
	}
	
	public List<String> query6(){
		return countryRepo.findLargeConstMonarchiesWithGoodLifeExpectancy();
	}

	public List<Object[]> query7(){
		return countryRepo.findBigCitiesInBuenosAiresDist();
	}

	public List<Object[]> query8(){
		return countryRepo.findNumCountriesPerRegion();
	}
}
