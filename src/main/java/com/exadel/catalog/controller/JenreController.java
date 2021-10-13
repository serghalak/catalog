package com.exadel.catalog.controller;

import com.exadel.catalog.request.JenreRequest;
import com.exadel.catalog.response.JenreResponse;
import com.exadel.catalog.service.JenreService;
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
public class JenreController {

    private final JenreService jenreService;

    @GetMapping(produces = {"application/json"}, path = "jenre")
    public Set<JenreResponse> listJenres() {

        return jenreService.listJenres();

    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = {"jenre"})
    public ResponseEntity<JenreResponse> createJenre(@RequestBody JenreRequest jenreRequest) {

        return new ResponseEntity<>(jenreService.createJenre(jenreRequest), HttpStatus.OK);

    }
}
