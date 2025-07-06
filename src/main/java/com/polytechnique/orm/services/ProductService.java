package com.polytechnique.orm.services;

import com.polytechnique.orm.entity.Product;
import com.polytechnique.orm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product){
        this.productRepository.save(product);
    }

    public Product read(Integer id){
        return this.productRepository.findById(id).orElse(null);
    }
    public List<Product> readAll(){
        return (List<Product>) this.productRepository.findAll();
    }

    public void update(Integer id,Product product){
        Product p = this.read(id);
        if(p!=null && p.getId()==id){
            p.setDescription(product.getDescription());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            this.productRepository.save(p);
        }
    }

    public void delete(Integer id){
        this.productRepository.deleteById(id);
    }
}
