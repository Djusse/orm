package com.polytechnique.orm.controller;

import com.polytechnique.orm.entity.Product;
import com.polytechnique.orm.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody @Valid Product product) {
        this.productService.create(product);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> listerProduits() {
        return this.productService.readAll();
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Product rechercher(@PathVariable Integer id) {
        return this.productService.read(id);
    }

    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void update(@PathVariable Integer id, @RequestBody @Valid Product product) {
        this.productService.update(id, product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Integer id) {
        this.productService.delete(id);
    }
}