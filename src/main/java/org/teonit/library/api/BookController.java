package org.teonit.library.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.teonit.library.domain.Book;
import org.teonit.library.domain.Language;
import org.teonit.library.domain.Organization;
import org.teonit.library.repositories.BookRepository;
import org.teonit.library.repositories.LanguageRepository;
import org.teonit.library.repositories.OrganizationRepository;

@RestController
@RequestMapping("book")
public class BookController {
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	OrganizationRepository organizationRepository;
	
	@RequestMapping
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void createBook(@RequestBody Book book) {
		Language language = languageRepository.findOneByCode(book.getLanguage().getCode());
		Organization organization = organizationRepository.findByName(book.getPublisher().getName());
		if(language != null) {
			book.setLanguage(language);
		} else {
			book.setLanguage(null);
		}
		if(organization != null)
			book.setPublisher(organization);
		else {
			book.setPublisher(null);
		}
		bookRepository.save(book);
	}
}
