package com.mongobasics.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongobasics.models.Book;

public interface IBooksRepository extends MongoRepository<Book, String> {

	
}
