package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Book;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.exception.AuthorNotFoundException;
import com.exadel.catalog.exception.JenreNotFoundException;
import com.exadel.catalog.exception.PublicationNotFoundException;
import com.exadel.catalog.mapper.BookMapper;
import com.exadel.catalog.mapper.PublisherMapper;
import com.exadel.catalog.repository.AuthorRepository;
import com.exadel.catalog.repository.BookRepository;
import com.exadel.catalog.repository.JenreRepository;
import com.exadel.catalog.repository.PublisherRepository;
import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.response.BookResponse;
import com.exadel.catalog.response.JenreResponse;
import com.exadel.catalog.response.PublisherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    private Book book1;

    private Book book2;

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private JenreRepository jenreRepository;

    @Mock
    private PublisherRepository publisherRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookMapper bookMapper;

    @Mock
    private BookRequest bookRequest1;

    @BeforeEach
    void setUp() {

        book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Java in action");
        book1.setIsbn("123-456-789");

        book2 = new Book();
        book2.setId(2L);
        book2.setTitle("Spring in action");
        book2.setIsbn("987-654-321");

        bookRequest1=new BookRequest();
        bookRequest1.setTitle("Java in action");
        bookRequest1.setIsbn("123-456-789");
        bookRequest1.setJenreId(1L);
        bookRequest1.setPublisherId(2L);
        bookRequest1.setAuthorIds(List.of(1L,2L));

    }

    @Test
    void shouldReturnAllBooksFromRepository() {

        List<Book> books= List.of(book1, book2);
        when((bookRepository.findAll())).thenReturn(books);

        assertNotNull(bookService.listBooks());
        assertEquals(2, books.size());
        assertNotEquals(3, books.size());
    }

    @Test
    void shouldThrowExceptionDuringSaveBookIfBookRequestIsNull() {

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    bookService.createBook(null);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveBookIfJenreIdIsNull() {

        bookRequest1.setJenreId(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveBookIfPublisherIdIsNull() {

        bookRequest1.setPublisherId(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    void shouldThrowExceptionDuringSaveBookIfAuthorIdsIsNull() {

        bookRequest1.setAuthorIds(null);

        RuntimeException exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    void shouldThrowExceptionIfJanreNotFoundById(){


        when((jenreRepository.findById(1L))).thenReturn(Optional.ofNullable(null));

        RuntimeException exception = assertThrows(JenreNotFoundException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    void shouldThrowExceptionIfPublisherNotFoundById(){

        Jenre jenre = new Jenre();
        when((jenreRepository.findById(1L))).thenReturn(Optional.ofNullable(jenre));
        when((publisherRepository.findById(2L))).thenReturn(Optional.ofNullable(null));

        RuntimeException exception = assertThrows(PublicationNotFoundException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    void shouldThrowExceptionIfAuthorsByIdsNotFound(){

        Jenre jenre = new Jenre();
        Publisher publisher = new Publisher();

        when((jenreRepository.findById(1L))).thenReturn(Optional.ofNullable(jenre));
        when((publisherRepository.findById(2L))).thenReturn(Optional.ofNullable(publisher));
        when(authorRepository.findAllAuthorByIds(List.of(1L, 2L))).thenReturn(null);

        RuntimeException exception = assertThrows(AuthorNotFoundException.class,
                () -> {
                    bookService.createBook(bookRequest1);
                });
    }

    @Test
    @Disabled
    void shouldReturnSavedAuthorResponse(){

        Jenre jenre = new Jenre();
        jenre.setId(1L);
        jenre.setName("WEB");

        Publisher publisher = new Publisher();
        publisher.setId(2L);
        publisher.setName("IT Today");
        publisher.setAddress("Iv-Frankivsk Mazepa 145");

        Author author1= new Author();
        author1.setId(1L);
        author1.setFirstName("Eric");
        author1.setLastName("Evans");

        Author author2 = new Author();
        author2.setId(2L);
        author2.setFirstName("Rod");
        author2.setLastName("Johnson");

        Set<Author> authors=Set.of(author1, author2);

        Book book = new Book();
        //book1.setId(null);
        book.setTitle("Java in action");
        book.setIsbn("123-456-789");
        book.setJenre(jenre);
        book.setPublisher(publisher);
        book.setAuthors(authors);

        Book saveBook = new Book();
        saveBook.setId(1L);
        saveBook.setTitle("Java in action");
        saveBook.setIsbn("123-456-789");
        saveBook.setJenre(jenre);
        saveBook.setPublisher(publisher);
        saveBook.setAuthors(authors);

        JenreResponse jenreResponse = new JenreResponse();
        jenreResponse.setId(1L);
        jenreResponse.setName("WEB");

        PublisherResponse publisherResponse = new PublisherResponse();
        publisherResponse.setId(2L);
        publisherResponse.setName("IT Today");
        publisherResponse.setAddress("Iv-Frankivsk Mazepa 145");

        AuthorResponse authorResponse1= new AuthorResponse();
        authorResponse1.setId(1L);
        authorResponse1.setFirstName("Eric");
        authorResponse1.setLastName("Evans");

        AuthorResponse authorResponse2= new AuthorResponse();
        authorResponse2.setId(2L);
        authorResponse2.setFirstName("Rod");
        authorResponse2.setLastName("Johnson");

        BookResponse bookResponse1=new BookResponse();
        bookResponse1.setId(1L);
        bookResponse1.setTitle("Java in action");
        bookResponse1.setIsbn("123-456-789");
        bookResponse1.setJenre(jenreResponse);
        bookResponse1.setPublisher(publisherResponse);

        bookResponse1.setAuthors(Set.of(authorResponse1,authorResponse2));

        when((jenreRepository.findById(1L))).thenReturn(Optional.ofNullable(jenre));
        when((publisherRepository.findById(2L))).thenReturn(Optional.ofNullable(publisher));
        when(authorRepository.findAllAuthorByIds(List.of(1L, 2L))).thenReturn(authors);
        when(bookRepository.save(book)).thenReturn(saveBook);
        //when(bookMapper.bookToBookResponse(book1)).thenReturn(bookResponse1);

        assertEquals(bookResponse1, bookService.createBook(bookRequest1));

    }
}