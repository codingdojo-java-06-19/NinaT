package com.ninatompkin.countries.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninatompkin.countries.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

	
//1 get all the countries that speak Slovene. return the name, language, and language percentage and sort by language percentage desc.

//2 get the total number of cities per country. return the country name and the total number of cities desc.

//3 get all the cities in Mexico with population greater than 500,000. return the cities by population desc.

//4 get all languages in each country with percentage greater than 89%? return by percentage desc.

//5 get all the countries with Surface Area below 501 and Population greater than 100,000?

//6 get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years

//7 get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000. Return the Country Name, City Name, District, and Population.

//8 get the number of countries in each region? Return name of the region and the number of countries, ordered by the number of countries desc.
	
	
	
}
