package com.explain.mindserver.controller;


import com.explain.mindserver.dto.ProductDTO;
import com.explain.mindserver.model.Product;
import com.explain.mindserver.service.ICrudService;
import com.explain.mindserver.service.IProductService;
import org.modelmapper.ModelMapper;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("products")
public class ProductController extends CrudController<Product, ProductDTO,Long> {

    private final IProductService service;

    private final ModelMapper modelMapper;

    public ProductController(Class<Product> typeClass, Class<ProductDTO> typeDtoClass, IProductService service, ModelMapper modelMapper) {
        super(Product.class, ProductDTO.class);
        this.service = service;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudService<Product, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }
}