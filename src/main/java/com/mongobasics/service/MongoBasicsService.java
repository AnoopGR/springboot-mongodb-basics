package com.mongobasics.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongobasics.repository.IBooksRepository;
import com.mongobasics.models.Book;

@Service
public class MongoBasicsService implements IMongoBasicsService{
	
	public static final Logger logger = LoggerFactory.getLogger(MongoBasicsService.class);
	
	@Autowired
	private IBooksRepository booksRepository;
	
	@Override
	public Book insertOneBook(Book data) {
		Book book = booksRepository.insert(data);
		return book;
	}
	
	@Override
	public List<Book> insertAllBooks(List<Book> data) {
		List<Book> book;
		book = (List<Book>)booksRepository.insert(data);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		return booksRepository.findAll();
		
	}
	
	@Override
	public Book updateBook(Book data) {
		Book book = booksRepository.save(data);
		return book;
		
	}

	@Override
	public void deleteBook(Book data) {
		booksRepository.delete(data);
	}
	
	@Override
	public void deleteAllBooks() {
		booksRepository.deleteAll();
		
	}

}
