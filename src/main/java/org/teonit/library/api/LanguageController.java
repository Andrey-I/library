package org.teonit.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.teonit.library.domain.Language;
import org.teonit.library.repositories.LanguageRepository;

@RestController
@RequestMapping("language")
public class LanguageController {

	@Autowired
	private LanguageRepository languageRepository;
	
	@RequestMapping(path = "{language}", method = RequestMethod.POST)
	public void create(@PathVariable String language ) {
		Language lang = new Language();
		lang.setName(language);
		languageRepository.save(lang);
	}
	
	@RequestMapping
	public List<Language> getAllLanguages() {
		return (List<Language>) languageRepository.findAll();
	}
}
