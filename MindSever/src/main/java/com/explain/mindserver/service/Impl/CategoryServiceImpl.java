package com.explain.mindserver.service.Impl;

import com.explain.mindserver.model.Category;
import com.explain.mindserver.repository.CategoryRepository;
import com.explain.mindserver.service.ICategoryService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl extends CrudServiceImpl<Category,Long> implements ICategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }
}
