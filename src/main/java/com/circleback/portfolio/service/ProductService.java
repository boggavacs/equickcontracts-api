package com.circleback.portfolio.service;

import com.circleback.portfolio.Repository.ProductRepository;
import com.circleback.portfolio.Repository.ProductRepositoryImpl;
import com.circleback.portfolio.entity.Posts;
import com.circleback.portfolio.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRepositoryImpl productRepositoryImpl;


    public List<Product> addProductDetails(Product product){
        productRepository.save(product);
        return getProductByName(product.getName());
    };

    public List<Product> getProductByName(String name){
//        return productRepository.findById(Integer.valueOf(id));
        return productRepositoryImpl.getProductByName(name);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }


}
