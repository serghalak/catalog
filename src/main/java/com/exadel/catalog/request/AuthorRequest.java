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
    @Size(min = 1, max = 255, message = "Author first name should be from 1 to 255")
    private String FirstName;

    @NotBlank(message = "Author last name is mandatory")
    @Size(min = 1, max = 255, message = "Author last name should be from 1 to 255")
    private String LastName;

}
