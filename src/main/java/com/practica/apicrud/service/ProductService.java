package com.practica.apicrud.service;

import com.practica.apicrud.data.entity.Product;
import com.practica.apicrud.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> productLis(){

        return productRepository.findAll();
    }
    public void saveProduct(Product product){

        productRepository.save(product);
    }
    public Product getProduct(Integer id){

        return productRepository.findById(id).get();
    }
    public void deleteProduct(Integer id){

        productRepository.deleteById(id);
    }
}
