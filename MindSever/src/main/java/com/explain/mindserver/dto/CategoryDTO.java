package com.explain.mindserver.dto;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    private Long id;

    @NotNull
    private String name;
}
