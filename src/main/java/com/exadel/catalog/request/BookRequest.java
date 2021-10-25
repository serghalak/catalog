package com.exadel.catalog.request;

import lombok.*;

import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 1, max = 255, message = "Title should be from 1 to 255")
    private String title;

    @NotBlank(message = "ISBN number is mandatory")
    private String isbn;

    @Min(value = 1, message = "Jenre id is wrong")
    private Long jenreId;

    @Min(value = 1, message = "Publisher id is wrong")
    private Long publisherId;

    @NotEmpty(message = "At least one author id is mandatory")
    private List<Long> authorIds;
}
