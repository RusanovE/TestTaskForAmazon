package com.example.testtaskforamazon.repositories;

import com.example.testtaskforamazon.entities.ReportSpecificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportSpecificationRepository extends MongoRepository<ReportSpecificationEntity, String > {

}
