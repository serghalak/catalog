package com.exadel.catalog.request;

import com.exadel.catalog.domain.Jenre;
import com.exadel.catalog.domain.Publisher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;

    private String isbn;

    private Jenre jenre;

    private Publisher publisher;
}
