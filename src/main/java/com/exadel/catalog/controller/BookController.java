package com.exadel.catalog.controller;

import com.exadel.catalog.exception.RequestArgumentIsNotPresentException;
import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.response.BookResponse;
import com.exadel.catalog.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/")
@RestController
public class BookController {

    private final BookService bookService;

    @GetMapping(produces = {"application/json"}, path = "book")
    public Set<BookResponse> listBooks() {

        return bookService.listBooks();

    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = {"book"})
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest bookRequest)
            throws RequestArgumentIsNotPresentException {

        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.OK);

    }
}
