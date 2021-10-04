package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;

import java.util.Set;

public interface AuthorService {

    Set<Author> findAll();
    Author findById(Long id);
    Author createAuthor(Author author);
    Author updateAuthor(Author author);
    void deleteAuthor(Author author);
    void deleteAuthorById(Long id);
    Set<Author>findByFistName(String firstName);
    Set<Author>findByLastName(String lastName);
}
