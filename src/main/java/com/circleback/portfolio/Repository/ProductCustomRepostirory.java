package com.circleback.portfolio.Repository;

import com.circleback.portfolio.entity.Product;

import java.util.List;

public interface ProductCustomRepostirory {
    public List<Product> getProductByName(String name);
}
