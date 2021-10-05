package com.exadel.catalog.mapper;

import com.exadel.catalog.domain.Author;
import com.exadel.catalog.domain.Book;
import com.exadel.catalog.request.AuthorRequest;
import com.exadel.catalog.request.BookRequest;
import com.exadel.catalog.response.AuthorResponse;
import com.exadel.catalog.response.BookResponse;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Component
public class BookMapper {

    private ModelMapper mapper;

    public BookResponse bookToBookResponse(Book book){
        return Objects.isNull(book) ? null : mapper.map(book, BookResponse.class);
    }

    public Book BookRequestToBook(BookRequest bookRequest){
        return Objects.isNull(bookRequest) ? null : mapper.map(bookRequest, Book.class);
    }
}
