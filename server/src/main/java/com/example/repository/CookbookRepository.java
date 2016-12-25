package com.example.repository;

import com.example.domain.Cookbook;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Ming on 2016/12/9.
 */
public interface CookbookRepository extends MongoRepository<Cookbook, Long> {

    Cookbook findByName(String name);

}
