package com.explain.mindserver.controller;

import com.explain.mindserver.dto.CategoryDTO;
import com.explain.mindserver.model.Category;
import com.explain.mindserver.service.ICategoryService;
import com.explain.mindserver.service.ICrudService;

import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.*;


@RestController @RequestMapping("Categories")
public class CategoryController extends CrudController<Category, CategoryDTO,Long> {

    private final ICategoryService service;

    private final ModelMapper modelMapper;

    public CategoryController(ICategoryService service, ModelMapper modelMapper) {
        super(Category.class, CategoryDTO.class);
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Category, Long> getService(){
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }


}
