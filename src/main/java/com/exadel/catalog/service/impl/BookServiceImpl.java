package com.exadel.catalog.service.impl;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Book;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import com.exadel.catalog.exception.JenreNotFoundException;
import com.exadel.catalog.exception.PublicationNotFoundException;
import com.exadel.catalog.mapper.BookMapper;
import com.exadel.catalog.repository.AuthorRepository;
import com.exadel.catalog.repository.BookRepository;
import com.exadel.catalog.repository.JenreRepository;
import com.exadel.catalog.repository.PublisherRepository;
import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.response.BookResponse;
import com.exadel.catalog.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final JenreRepository jenreRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;


    @Override
    public Set<BookResponse> listBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::bookToBookResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {

        if (bookRequest == null) {
            throw new IllegalArgumentException("The book cannot be empty");
        }

        Long jenreId = bookRequest.getJenreId();
        if(jenreId == null){
            throw new IllegalArgumentException("The janre id cannot be empty");
        }

        Long publisherId = bookRequest.getPublisherId();
        if(publisherId == null){
            throw new IllegalArgumentException("The publisher id cannot be empty");
        }

        List<Long> authorIds = bookRequest.getAuthorIds();
        if(authorIds == null){
            throw new IllegalArgumentException("There is no any author");
        }

        Jenre jenreById = jenreRepository.findById(jenreId)
                .orElseThrow(() -> new JenreNotFoundException(String.format("Jenre with id %d not found", jenreId)));

        Publisher publisherById = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new PublicationNotFoundException(String.format("Publisher with id %d not found", publisherId)));

        Set<Author> authors = authorRepository.findAllAuthorByIds(authorIds);

        Book book = new Book();
        book.setTitle(bookRequest.getTitle());
        book.setIsbn(bookRequest.getIsbn());
        book.setJenre(jenreById);
        book.setPublisher(publisherById);
        book.setAuthors(authors);

        Book saveBook = bookRepository.save(book);

        return bookMapper.bookToBookResponse(saveBook);
    }
}
