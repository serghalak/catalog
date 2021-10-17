package com.exadel.catalog.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponse {

    private Long id;

    private String title;

    private String isbn;

    private JenreResponse jenre;

    private PublisherResponse publisher;

    private Set<AuthorResponse> authors;
}
