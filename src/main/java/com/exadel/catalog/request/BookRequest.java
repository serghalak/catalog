package com.exadel.catalog.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String title;

    private String isbn;

    private Long jenreId;

    private Long publisherId;

    private List<Long> authorIds;
}
