package com.exadel.catalog.response;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
public class BookResponse {
    private Long id;
    private String title;
    private String isbn;
    private JenreResponse jenre;
    private PublisherResponse publisher;
    private Set<AuthorResponse> authors;
}
