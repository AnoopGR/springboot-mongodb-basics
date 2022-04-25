package com.mongobasics.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
	@Id
	private ObjectId id;
	private String bookName;
	private String author;
	private Integer price;
	
	public Book(String bookName, String author, Integer price)
	{
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}
	
	public ObjectId getId()
	{
		return id;
	}
	
	public void setId(ObjectId id)
	{
		this.id = id;
	}
	
	public String getBookName()
	{
		return bookName;
	}
	
	public void setBookName(String bookName)
	{
		this.bookName = bookName;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public Integer getPrice()
	{
		return price;
	}
	
	public void setPrice(Integer price)
	{
		this.price = price;
	}
}
