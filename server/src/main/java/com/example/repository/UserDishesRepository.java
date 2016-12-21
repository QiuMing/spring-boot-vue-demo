package com.example.repository;

import com.example.domain.UserDishes;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ming on 2016/12/9.
 */
public interface UserDishesRepository extends MongoRepository<UserDishes, Long> {
}
