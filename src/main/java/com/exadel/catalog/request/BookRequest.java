package com.exadel.catalog.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;

    private String isbn;

    private Long jenreId;

    private Long publisherId;

    private List<Long> authorIds;
}
