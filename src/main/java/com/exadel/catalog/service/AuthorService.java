package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;

import java.util.Set;

public interface AuthorService {

    Set<AuthorResponse> listAuthors();

    AuthorResponse findAuthorById(Long id);
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse updateAuthor(Author author);
    void deleteAuthor(Author author);
    void deleteAuthorById(Long id);
    Set<AuthorResponse>findByFistName(String firstName);
    Set<AuthorResponse>findByLastName(String lastName);
}
