package com.ninatompkin.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ninatompkin.languages.models.Language;
import com.ninatompkin.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	//returns all the Books
	public List<Language> allLanguages(){
		return langRepo.findAll();
	}
	
	//creates a Book
	public Language addLanguage(Language lang) {
		return langRepo.save(lang);
	}
	
	//retrieves a book
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} 
		else {
			return null;
			}
		}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Language langFromDB = langRepo.findById(id).get();
		langFromDB.setName(name);
		langFromDB.setCreator(creator);
		langFromDB.setVersion(version);
		return updateLanguage(langFromDB);
	}
	
	public Language updateLanguage(Language lang) {
		langRepo.save(lang);
		return lang;
	}
	
	public void deleteLanguage(Long id) {
		langRepo.deleteById(id);
	}
}
