package com.mongobasics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mongobasics.models.Book;
import com.mongobasics.service.MongoBasicsService;

@SpringBootTest
class MongoBasicsTests {
	
    @Autowired
    private MongoBasicsService mongobasicsservice;

    @Test
    public void insertOneBookTest() {
        Book book = new Book("Bookname", "Author", 100);
        Book result = mongobasicsservice.insertOneBook(book);
                
        assertEquals(book, result);
    }
    
    @Test
    public void insertAllBooksTest() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Book1", "Author1", 101));
		books.add(new Book("Book2", "Author2", 101));
		books.add(new Book("Book3", "Author3", 102));
		books.add(new Book("Book4", "Author4", 103));
		books.add(new Book("Book5", "Author5", 104));
		List<Book> result = mongobasicsservice.insertAllBooks(books);

        assertEquals(books, result);
    }
    
    @Test
    public void getAllBooksTest() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Book1", "Author1", 101));
		books.add(new Book("Book2", "Author2", 101));
		books.add(new Book("Book3", "Author3", 102));
		books.add(new Book("Book4", "Author4", 103));
		books.add(new Book("Book5", "Author5", 104));
		List<Book> result = mongobasicsservice.insertAllBooks(books);
		assertEquals(books, result);
		
		List<Book> getResults = mongobasicsservice.getAllBooks();             
        assertEquals(5, getResults.size());
        
        for (Book book : getResults)
        {
        	System.out.println(book.getId() + ": "+ book.getBookName() + ", "+ book.getAuthor() + ", " + book.getPrice());
        }
    }
    
    @Test
    public void updateBookTest() {
        Book book = new Book("Bookname", "Author", 100);
        Book result = mongobasicsservice.insertOneBook(book);
        assertEquals(book, result);
        
        book.setId(result.getId()); 
        book.setBookName("NewBookname");
        book.setAuthor("NewAuthor");
        book.setPrice(200);
        
        Book updateresult = mongobasicsservice.updateBook(book);
        assertEquals(book, updateresult);
    }
    
    @Test
    public void deleteBookTest() {
        Book book = new Book("Bookname", "Author", 100);
        Book result = mongobasicsservice.insertOneBook(book);
        assertEquals(book, result);
        mongobasicsservice.deleteBook(book);
        List<Book> getResults = mongobasicsservice.getAllBooks();
        assertEquals(0, getResults.size());
    }
    
    @AfterEach
    public void tearDown(){
    	mongobasicsservice.deleteAllBooks();
    }
}
