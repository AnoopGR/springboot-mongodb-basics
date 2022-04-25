package com.mongobasics.service;

import java.util.List;

import com.mongobasics.models.Book;

public interface IMongoBasicsService {

	Book insertOneBook(Book data);
	List<Book> insertAllBooks(List<Book> data);
	void deleteAllBooks();
	List<Book> getAllBooks();
	Book updateBook(Book data);
	void deleteBook(Book data);
}