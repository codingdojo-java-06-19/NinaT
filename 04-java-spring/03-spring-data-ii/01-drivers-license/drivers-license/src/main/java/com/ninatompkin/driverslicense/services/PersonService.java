package com.ninatompkin.driverslicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninatompkin.driverslicense.models.License;
import com.ninatompkin.driverslicense.models.Person;
import com.ninatompkin.driverslicense.repositories.PersonRepository;

@Service
public class PersonService {
	private final PersonRepository personRepo;
	
	public PersonService(PersonRepository personRepo) {
		this.personRepo = personRepo;
	}
	
	//Adds a person into the DB
	public Person addPerson(Person person) {
		return personRepo.save(person);
	}
	
	//Returns all people with licenses
	public List<Person> allPeople(){
		return personRepo.findAll();
	}
	
	//Returns all people who don't have licenses
	public List<Person> getAllWithNoLicense(){
		return personRepo.findAllByLicenseIsNull();
	}
	
	//Adds a license to a person
	public void addLicenseToPerson(License license, Person person) {
		person.setLicense(license);
		personRepo.save(person);
	}
	
	//Finds a person by a String (i.e. through a form)
	public Person findPerson(String id) {
		return findPerson(Long.parseLong(id));
	}
	
	//Finds a person by an integer
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepo.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		}
		else {
			return null;
		}
		
	}
}
