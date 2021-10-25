package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.exception.AuthorNotFoundException;
import com.exadel.catalog.mapper.AuthorMapper;
import com.exadel.catalog.repository.AuthorRepository;
import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

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
                .orElseThrow(() -> new AuthorNotFoundException("Author with id " + id + " not found"));
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {

        String firstName = authorRequest.getFirstName();
        String lastName = authorRequest.getLastName();

        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException("The first name cannot be empty");
        }

        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException("The last name cannot be empty");
        }

        Author author = authorMapper.authorRequestToAuthor(authorRequest);
        Author saveAuthor = authorRepository.save(author);

        return authorMapper.authorToAuthorResponse(saveAuthor);
    }

}
