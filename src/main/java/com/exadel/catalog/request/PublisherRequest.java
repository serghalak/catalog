package com.exadel.catalog.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherRequest {

    @NotBlank(message = "Publisher name is mandatory")
    @Size(min = 1, max = 255, message = "Publisher name should be from 1 to 255")
    private String name;

    @NotBlank(message = "Address of publisher is mandatory")
    @Size(min = 1, max = 255, message = "Address of publisher should be from 1 to 255")
    private String address;
}
