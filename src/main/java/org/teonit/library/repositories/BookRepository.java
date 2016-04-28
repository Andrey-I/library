package org.teonit.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.teonit.library.domain.Book;

/**
 * Book repository.
 *
 * @author Andrii Iakovenko
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
