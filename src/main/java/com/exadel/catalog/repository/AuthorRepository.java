package com.exadel.catalog.repository;

import com.exadel.catalog.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
