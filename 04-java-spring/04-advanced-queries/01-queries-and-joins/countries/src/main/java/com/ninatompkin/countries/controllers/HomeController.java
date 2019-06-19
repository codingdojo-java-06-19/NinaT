package com.ninatompkin.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ninatompkin.countries.services.ApiService;

@Controller
public class HomeController {
	private final ApiService apiService;
	
	public HomeController(ApiService apiService) {
		this.apiService = apiService;
	}

	@RequestMapping("/")
	public void showStuff() {
		
		//QUERY 1 TESTED - IT WORKS
//		List<Object[]> table=apiService.query1();
//		for(Object[] row:table) {
//			String countryName = (String) row[0];
//			String language = (String) row[1];
//			Double percentage = (Double) row[2];
//			System.out.println("Country: "+countryName+" language: "+ language+" percentage: "+percentage);
//		}
		
		//QUERY 2 TESTED - IT WORKS
//		List<Object[]> table=apiService.query2();
//		for(Object[] row: table) {
//			String countryName = (String) row[0];
//			Long cityCount = (Long)row[1];
//			System.out.println(countryName +" number of cities: "+ cityCount);
//		}
		
		//QUERY 3 TESTED - IT WORKS
//		System.out.println(apiService.query3());
		
		//QUERY 4 TESTED - IT WORKS
//		System.out.println(apiService.query4());
		
		//QUERY 5 TESTED - IT WORKS
//		System.out.println(apiService.query5());
		
		//QUERY 6 TESTED - IT WORKS
//		System.out.println(apiService.query6());
		
		//QUERY 7 TESTED - IT WORKS
//		List<Object[]> table=apiService.query7();
//		for(Object[] row:table) {
//			String countryName = (String)row[0];
//			String cityName = (String)row[1];
//			String cityDistrict = (String)row[2];
//			int population = (Integer)row[3];
//			System.out.println(countryName+" City: "+cityName+" District: "+cityDistrict+" Population: "+population);
//		}
		
		//QUERY 8 TESTED - IT WORKS
//		List<Object[]> table=apiService.query8();
//		for(Object[] row:table) {
//			String countryRegion = (String)row[0];
//			Long countryCount = (Long)row[1];
//			System.out.println(countryRegion+countryCount);
//		}
	}
}
