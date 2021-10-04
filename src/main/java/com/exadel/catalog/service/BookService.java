package com.exadel.catalog.service;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Book;

import java.util.Set;

public interface BookService {

    Set<Book> findAll();
    Book findById(Long id);
    Book createBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Book book);
    void deleteBookById(Long id);
    Set<Book>findByTitle(String title);
    Set<Book>findByIsbn(String isbn);
}
