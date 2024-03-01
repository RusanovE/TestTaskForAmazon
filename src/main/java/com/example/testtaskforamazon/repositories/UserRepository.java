package com.example.testtaskforamazon.repositories;

import com.example.testtaskforamazon.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findByLogin(String login);
}
