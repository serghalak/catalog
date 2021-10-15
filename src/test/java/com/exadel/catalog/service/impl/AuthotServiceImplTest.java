package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.exception.AuthorNotFoundException;
import com.exadel.catalog.mapper.AuthorMapper;
import com.exadel.catalog.repository.AuthorRepository;
import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthotServiceImplTest {

    private Author author1;

    private Author author2;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private AuthorMapper authorMapper;

    @Mock
    private AuthorRequest authorRequest;

    @BeforeEach
    void setUp() {
        author1 = new Author();
        author1.setId(1L);
        author1.setFirstName("FirstName1");
        author1.setLastName("LastName1");

        author2 = new Author();
        author2.setId(2L);
        author2.setFirstName("FirstName1");
        author2.setLastName("LastName2");
    }


    @Test
    void shouldReturnAllAuthorsFromRepository() {

        List<Author>authors= List.of(author1, author2);
        when((authorRepository.findAll())).thenReturn(authors);

        assertNotNull(authorService.listAuthors());
        assertEquals(2, authors.size());
        assertNotEquals(3, authors.size());
    }

    @Test
    void shouldReturnAuthorResponseIfAuthorIsPresentAuthorById() {

        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(1L);
        authorResponse.setFirstName("FirstName1");
        authorResponse.setLastName("LastName1");

        when((authorRepository.findById(1L))).thenReturn(java.util.Optional.ofNullable(author1));
        when(authorMapper.authorToAuthorResponse(author1)).thenReturn(authorResponse);
        assertEquals(authorResponse, authorService.findAuthorById(1L));
    }

    @Test
    void shouldThrowExceptionFindAuthorByIdIfAuthorNotFound() {

        when((authorRepository.findById(3L))).thenReturn(java.util.Optional.ofNullable(null));

        RuntimeException exception = assertThrows(AuthorNotFoundException.class,
                () -> {
                    authorService.findAuthorById(3L);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveAuthorIfFirstNameIsEmpty() {

        when(authorRequest.getFirstName()).thenReturn("");

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    authorService.createAuthor(authorRequest);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveAuthorIfLastNameIsEmpty() {

        when(authorRequest.getLastName()).thenReturn("");

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    authorService.createAuthor(authorRequest);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveAuthorIfFirstNameIsNull() {

        when(authorRequest.getFirstName()).thenReturn(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    authorService.createAuthor(authorRequest);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveAuthorIfLastNameIsNull() {

        when(authorRequest.getLastName()).thenReturn(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    authorService.createAuthor(authorRequest);
                });
    }

    @Test
    void shouldReturnAuthorResponseDuringSaveAuthorRequest(){
        AuthorResponse authorResponse = new AuthorResponse();
        authorResponse.setId(1L);
        authorResponse.setFirstName("FirstName1");
        authorResponse.setLastName("LastName1");

        AuthorRequest authorRequest = new AuthorRequest();
        authorRequest.setFirstName("FirstName1");
        authorRequest.setLastName("LastName1");

        Author authorBeforeSave = new Author();
        authorBeforeSave.setFirstName("FirstName1");
        authorBeforeSave.setLastName("LastName1");

        when(authorMapper.AuthorRequestToAuthor(authorRequest)).thenReturn(authorBeforeSave);
        when(authorRepository.save(authorBeforeSave)).thenReturn(author1);
        when(authorMapper.authorToAuthorResponse(author1)).thenReturn(authorResponse);

        assertEquals(authorResponse, authorService.createAuthor(authorRequest));
    }
}