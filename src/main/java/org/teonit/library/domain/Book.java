package org.teonit.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * This class represents Book.
 * 
 * {@link https://schema.org/Book Book}
 * 
 * @author Andrii Iakovenko
 *
 */
@Entity
@SequenceGenerator(name="book_id", sequenceName="book_id_seq", allocationSize=1)
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="book_id")
	private Long id;

	@Column(unique=true)
	private String isbn;
	
	private String name;

	private String url;

	private String description;

	@ManyToOne
	private Organization publisher;

	@ManyToOne
	private Language language;

	private Long numberOfPages;
	
	/**
	 * Create a new instance of {@code Book}
	 *
	 */
	public Book() {
	}
	
	/**
	 * Create a new instance of {@code Book}
	 *
	 * @param name the book name.
	 */
	public Book(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the publisher
	 */
	public Organization getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Organization publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the Language
	 */

	public Language getLanguage() {
		return language;
	}
	
	/**
	 * @param language the Language to set
	 */

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	/**
	 * @return the numberOfPages
	 */
	public Long getNumberOfPages() {
		return numberOfPages;
	}

	/**
	 * @param numberOfPages the numberOfPages to set
	 */
	public void setNumberOfPages(Long numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", name=" + name + ", url=" + url + ", description=" + description
				+ ", publisher=" + publisher + ", Language=" + language + ", numberOfPages=" + numberOfPages + "]";
	}

	
}
