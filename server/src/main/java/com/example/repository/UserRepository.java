package com.example.repository;

import com.example.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ming on 2016/12/9.
 */
public interface UserRepository extends MongoRepository<User, Long> {
    User findByName(String name);
}