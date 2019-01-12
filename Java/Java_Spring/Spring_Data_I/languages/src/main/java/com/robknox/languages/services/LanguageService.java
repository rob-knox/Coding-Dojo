package com.robknox.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robknox.languages.models.Language;
import com.robknox.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// Instance
	private final LanguageRepository languageRepository;
	private Language language;
	
	// Dependency Injection
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}
	// Returns all the languages
	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}
	// Creates a language
	public Language createLanguage(Language language) {
		return languageRepository.save(language);
	}
	// Retrieves a language
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		} else {
			return null;
		}
	}
	// Updates a language
	public Language updateLanguage(Long id, String name, String creator, Double version) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			return languageRepository.save(language);
		} else {
			return null;
		}
	}
	public Language updateLanguage(Language language) {
		return languageRepository.save(language);
	}
	// Deletes a language
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = languageRepository.findById(id);
		if (optionalLanguage.isPresent()) {
			languageRepository.deleteById(id);
		}
	}
}
