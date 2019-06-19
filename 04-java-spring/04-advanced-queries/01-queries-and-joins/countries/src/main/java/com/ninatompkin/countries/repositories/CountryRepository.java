package com.ninatompkin.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ninatompkin.countries.models.City;
import com.ninatompkin.countries.models.Country;
import com.ninatompkin.countries.models.Language;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

	
////1 get all the countries that speak Slovene. return the name, language, and language percentage and sort by language percentage desc.
@Query("SELECT country.name, language.language, language.percentage FROM Country AS country JOIN country.languages AS language WHERE language.language LIKE 'Slovene' ORDER BY language.percentage DESC")
List<Object[]> findSloveneSpeakingCountriesByPercentage();
	
//////2 get the total number of cities per country. return the country name and the total number of cities desc.
@Query("SELECT country.name, COUNT(city.id) AS city_count FROM Country AS country JOIN country.cities AS city GROUP BY country.name ORDER BY city_count DESC")
List<Object[]> countCitiesPerCountryDesc();

////3 get all the cities in Mexico with population greater than 500,000. return the cities by population desc.
@Query("SELECT city.name FROM Country AS country JOIN country.cities as city WHERE country.name='Mexico' AND city.population > 500000 ORDER BY city.population DESC")
List<String> findBigCitiesMexicoDesc();
//
////4 get all languages in each country with percentage greater than 89%? return by percentage desc.
@Query("SELECT language.language FROM Language AS language WHERE language.percentage > 89 ORDER BY language.percentage DESC")
List<String> findDominantLanguagesPerCountryDesc();
//
////5 get all the countries with Surface Area below 501 and Population greater than 100,000?
@Query("SELECT country.name FROM Country AS country WHERE country.surface_area < 501 AND country.population > 100000")
List <String> findSmallCountriesWithBigPopulations();

////6 get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years
@Query("SELECT country.name FROM Country AS country WHERE country.government_form ='Constitutional Monarchy' AND country.surface_area > 200 AND country.life_expectancy > 75")
List<String> findLargeConstMonarchiesWithGoodLifeExpectancy();

////7 get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000. Return the Country Name, City Name, District, and Population.
@Query("SELECT country.name, city.name, city.district, city.population FROM City AS city JOIN city.country AS country WHERE country.name='Argentina' AND city.district='Buenos Aires' AND city.population > 500000")
List<Object[]> findBigCitiesInBuenosAiresDist();

////8 get the number of countries in each region? Return name of the region and the number of countries, ordered by the number of countries desc.
@Query("SELECT country.region, COUNT(country.id) FROM Country AS country GROUP BY country.region ORDER BY COUNT(country.id) DESC")
List<Object[]> findNumCountriesPerRegion();
}
