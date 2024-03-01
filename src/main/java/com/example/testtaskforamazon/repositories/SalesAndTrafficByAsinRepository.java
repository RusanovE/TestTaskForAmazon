package com.example.testtaskforamazon.repositories;

import com.example.testtaskforamazon.entities.SalesAndTrafficByASINEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAndTrafficByAsinRepository extends MongoRepository<SalesAndTrafficByASINEntity,String> {

}
