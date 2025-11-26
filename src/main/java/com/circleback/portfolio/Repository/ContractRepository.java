package com.circleback.portfolio.Repository;

import com.circleback.portfolio.entity.Product;
import com.circleback.portfolio.entity.contract.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends MongoRepository<Rental, Integer> {
}
