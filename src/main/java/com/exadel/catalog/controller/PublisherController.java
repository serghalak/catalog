package com.exadel.catalog.controller;

import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.request.PublisherRequest;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.response.PublisherResponse;
import com.exadel.catalog.service.AuthorService;
import com.exadel.catalog.service.PublisherService;
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
public class PublisherController {

    private final PublisherService publisherService;

    @GetMapping(produces = {"application/json"}, path = "publisher")
    public Set<PublisherResponse> listPublishers() {

        return publisherService.listPublishers();

    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = {"publisher"})
    public ResponseEntity<PublisherResponse> createPublisher(@RequestBody PublisherRequest publisherRequest) {

        return new ResponseEntity<>(publisherService.createPublisher(publisherRequest), HttpStatus.OK);

    }
}
