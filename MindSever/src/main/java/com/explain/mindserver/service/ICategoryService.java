package com.explain.mindserver.service;

import com.explain.mindserver.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);

    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    Category findById(Long id);

    boolean exists(Long id);

    void deleteById(Long id);
}
