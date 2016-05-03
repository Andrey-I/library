package org.teonit.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class represents language.
 *
 * @author Andrii Iakovenko
 *
 */
@Entity
@SequenceGenerator(name="language_id", sequenceName="language_id_seq", allocationSize=1)
public class Language {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="language_id")
	private Long id;
	
	@Column(length=3, nullable=false)
	private String code;
	
	private String name;

	/**
	 * Create a new instance of {@code Language}
	 *
	 */
	public Language() {
	}

	/**
	 * Create a new instance of {@code Language}
	 *
	 * @param code
	 * @param name
	 */
	public Language(String code, String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String id) {
		this.code = id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
	
}
