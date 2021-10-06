package com.exadel.catalog.controller;

import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
