package org.teonit.library.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teonit.library.domain.Organization;

/**
 * Organization repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	Collection<Organization> findByNameLike(String name);
	Organization findByName(String name);

}
