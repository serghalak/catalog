package com.exadel.catalog.repository;

import com.exadel.catalog.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
