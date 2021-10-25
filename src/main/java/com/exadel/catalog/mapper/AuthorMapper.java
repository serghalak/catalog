package com.exadel.catalog.mapper;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.response.AuthorResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class AuthorMapper {

    private ModelMapper mapper;

    public AuthorResponse authorToAuthorResponse(Author author) {
        return Objects.isNull(author) ? null : mapper.map(author, AuthorResponse.class);
    }

    public Author authorRequestToAuthor(AuthorRequest authorRequest) {
        return Objects.isNull(authorRequest) ? null : mapper.map(authorRequest, Author.class);
    }


}
