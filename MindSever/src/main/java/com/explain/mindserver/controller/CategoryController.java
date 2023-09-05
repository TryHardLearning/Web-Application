package com.explain.mindserver.controller;

import com.explain.mindserver.model.Category;
import com.explain.mindserver.service.ICategoryService;
import com.explain.mindserver.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequestMapping("Categories")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody @Valid Category category){
        categoryService.save(category);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(location).body(categoryService.save(category));
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<GenericResponse> delete(Long id){
        if(categoryService.exists(id)){
            categoryService.deleteById(id);
            return ResponseEntity.ok(GenericResponse.builder().message("Success Delete Category").build());
        }

        return ResponseEntity.internalServerError(GenericResponse.builder().message("Error ID dont exist").build());
    }
}
