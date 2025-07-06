package com.polytechnique.orm.repository;

import com.polytechnique.orm.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
