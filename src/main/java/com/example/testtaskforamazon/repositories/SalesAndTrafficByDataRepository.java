package com.example.testtaskforamazon.repositories;

import com.example.testtaskforamazon.entities.SalesAndTrafficByDataEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SalesAndTrafficByDataRepository extends MongoRepository<SalesAndTrafficByDataEntity,String> {

}
