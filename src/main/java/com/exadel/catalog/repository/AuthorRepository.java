package com.exadel.catalog.repository;

import com.exadel.catalog.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a where a.id  in ?1")
    Set<Author> findAllAuthorByIds(List<Long> ids);
}
