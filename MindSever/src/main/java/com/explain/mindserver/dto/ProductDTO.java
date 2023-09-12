package com.explain.mindserver.dto;

import com.explain.mindserver.model.Category;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Double price;

    @ManyToOne @NotNull
    private Category category;
}
