package com.circleback.portfolio.Repository;

import com.circleback.portfolio.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepositoryImpl implements ProductCustomRepostirory {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Product> getProductByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        return mongoTemplate.find(query, Product.class);
    }
}
