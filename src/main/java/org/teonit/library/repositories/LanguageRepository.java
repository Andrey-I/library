package org.teonit.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teonit.library.domain.Language;

/**
 * Language repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {
	
	Language findOneByCode(String code);

}
