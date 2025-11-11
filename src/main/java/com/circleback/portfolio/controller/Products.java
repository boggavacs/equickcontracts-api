package com.circleback.portfolio.controller;

import com.circleback.portfolio.entity.Product;
import com.circleback.portfolio.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class Products {

    private ProductService productService;

    @GetMapping("/users")
    public ResponseEntity<List<Product>> getUser(){

        List<Product> products = Arrays.asList(
                Product.builder().name("person1").age("20").build(),
                Product.builder().name("person2").age("20").build(),
                Product.builder().name("person3").age("21").build(),
                Product.builder().name("person4").age("22").build()
        );
        List<Product> filteredProducts =  products.stream().filter(product -> product.getAge().equals("20")).collect(Collectors.toList());
        return ResponseEntity.ok(filteredProducts);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product product){
        Product createProduct = Product.builder()
                .name(product.getName())
                .age(product.getAge())
                .email(product.getEmail())
                .build();
        List<Product> newProduct =  productService.addProductDetails(createProduct);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.getProductByName(name));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok( productService.getProducts());
    }
}
