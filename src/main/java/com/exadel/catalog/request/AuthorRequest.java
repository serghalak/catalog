package com.exadel.catalog.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

    @NotBlank(message = "Author first name is mandatory")
    @Size(min = 1, max = 255, message = "Author first name length should be from 1 to 255")
    private String firstName;

    @NotBlank(message = "Author last name is mandatory")
    @Size(min = 1, max = 255, message = "Author last name length should be from 1 to 255")
    private String lastName;

}
