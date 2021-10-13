package com.exadel.catalog.service;

import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;

import java.util.Set;

public interface AuthorService {

    Set<AuthorResponse> listAuthors();

    AuthorResponse createAuthor(AuthorRequest authorRequest);

    AuthorResponse findAuthorById(Long id);

}
