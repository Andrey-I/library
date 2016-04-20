package org.teonit.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public void createLanguage(@RequestBody Language language) {
		languageRepository.save(language);
	}
	
	@RequestMapping
	public List<Language> getAllLanguages() {
		List<Language> records = (List<Language>) languageRepository.findAll();
		records.forEach(System.out::println);
		return records;
	}
	
	@RequestMapping(path = "{languageCode}", method=RequestMethod.DELETE)
	public void deleteLanguage(@PathVariable("languageCode") String code) {
		Language entity = languageRepository.findOneByCode(code);
		if(entity != null) {
			languageRepository.delete(entity);
		}
	}
}
