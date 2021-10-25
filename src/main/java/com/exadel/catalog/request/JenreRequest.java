package com.exadel.catalog.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JenreRequest {

    @NotBlank(message = "Jenre name is mandatory")
    @Size(min = 1, max = 255, message = "Jenre name length should be from 1 to 255")
    private String name;
}
