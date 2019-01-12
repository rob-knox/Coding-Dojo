package com.robknox.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robknox.languages.models.Language;
import com.robknox.languages.services.LanguageService;

@Controller
public class LanguagesController {
	// instance
	private final LanguageService languageService;
	
	// dependency injection
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	// home page
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("languageObj") Language language, BindingResult result) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	// create language
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("languageObj") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// show one language
	@RequestMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("language", language);
		return "/languages/show.jsp";
	}
	
	// edit a language
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		model.addAttribute("languageObj", language);
		return "/languages/edit.jsp";
	}
	
	// update a language
	@RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("languageObj") Language language, BindingResult result) {
		System.out.println("Came to the put request");
		if (result.hasErrors()) {
			System.out.println("doesnt work");
			return "/languages/edit.jsp";
		} else {
			System.out.println("works");
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	// delete a language
	@RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
}