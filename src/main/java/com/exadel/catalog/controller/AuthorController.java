package com.exadel.catalog.controller;

import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/")
@RestController
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping(produces = {"application/json"}, path = "author")
    public Set<AuthorResponse> listCategories() {

        return authorService.listAuthors();

    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = {"author"})
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) {

        return new ResponseEntity<>(authorService.createAuthor(authorRequest), HttpStatus.OK);

    }
}
