package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Book;
import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.response.BookResponse;

import java.util.Set;

public interface BookService {

    Set<BookResponse> listBooks();
    BookResponse createBook(BookRequest bookRequest);

//    Book findById(Long id);
//
//    Book updateBook(Book book);
//    void deleteBook(Book book);
//    void deleteBookById(Long id);
//    Set<Book>findByTitle(String title);
//    Set<Book>findByIsbn(String isbn);
}
