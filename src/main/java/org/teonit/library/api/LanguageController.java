package org.teonit.library.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.teonit.library.domain.Language;
import org.teonit.library.repositories.LanguageRepository;
import org.teonit.library.test.MyTestClass;
import org.teonit.library.test.mySingleton;

@RestController
@RequestMapping("language")
public class LanguageController implements ApplicationContextAware {

	Logger logger = LoggerFactory.getLogger(LanguageController.class);
	ApplicationContext appContext;
	
	@Autowired
	private LanguageRepository languageRepository;
	
	@Autowired
	mySingleton ss;

	@RequestMapping(method = RequestMethod.POST)
	public void createLanguage(@RequestBody Language language) {
		languageRepository.save(language);
	}
	
	@RequestMapping
	public List<Language> getAllLanguages() {
		List<Language> records = (List<Language>) languageRepository.findAll();
		records.forEach((l) -> {logger.info(l.toString());});
		logger.info("==================== all beans ===============");
		for(String name: appContext.getBeanDefinitionNames()) {
			logger.info(name);
		}
		return records;
	}
	
	@RequestMapping(path = "{languageCode}", method=RequestMethod.DELETE)
	public void deleteLanguage(@PathVariable("languageCode") String code) {
		Language entity = languageRepository.findOneByCode(code);
		if(entity != null) {
			languageRepository.delete(entity);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		logger.info("here " + ss.toString());
		this.appContext = applicationContext;
		
		
	}
}
