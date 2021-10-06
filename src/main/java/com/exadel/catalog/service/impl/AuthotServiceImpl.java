package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.mapper.AuthorMapper;
import com.exadel.catalog.repository.AuthorRepository;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class AuthotServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;


    @Override
    public Set<AuthorResponse> listAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::authorToAuthorResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public AuthorResponse findAuthorById(Long id) {

        return authorRepository.findById(id)
                .map(authorMapper::authorToAuthorResponse)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + " not found"));
    }

    @Override
    public AuthorResponse createAuthor(Author author) {
        return null;
    }

    @Override
    public AuthorResponse updateAuthor(Author author) {
        return null;
    }

    @Override
    public void deleteAuthor(Author author) {

    }

    @Override
    public void deleteAuthorById(Long id) {

    }

    @Override
    public Set<AuthorResponse> findByFistName(String firstName) {
        return null;
    }

    @Override
    public Set<AuthorResponse> findByLastName(String lastName) {
        return null;
    }
}
