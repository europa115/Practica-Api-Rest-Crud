package com.practica.apicrud.controller;

import com.practica.apicrud.data.entity.Product;
import com.practica.apicrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products") //Peticion GET para obtener datos
    public List<Product> listProducts(){

        return productService.productLis();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer id){
        try{

            Product product=productService.getProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/products") //Peticion POST para guardar datos
    public void saveProduct(@RequestBody Product product){

        productService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<?> actualizeProducts (@RequestBody Product product, @PathVariable Integer id){

        try{
            Product productUpdate=productService.getProduct(id);

            productUpdate.setName(product.getName());
            productUpdate.setPrice(product.getPrice());

            productService.saveProduct(productUpdate);
            return new ResponseEntity<Product>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);

    }
}
