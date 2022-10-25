package com.example.demo.content.repository;

import com.example.demo.content.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends MongoRepository<Content, String> {
    Content findTopById(String id);
}
