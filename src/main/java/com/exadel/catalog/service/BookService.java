package com.exadel.catalog.service;

import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.response.BookResponse;

import java.util.Set;

public interface BookService {

    Set<BookResponse> listBooks();

    BookResponse createBook(BookRequest bookRequest);

}
