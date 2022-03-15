package com.qa.books.service;

import java.util.List;
import java.util.Optional;

import com.qa.books.entity.Book;
import com.qa.books.repo.BookRepo;

public class BookService implements ServiceMethods<Book>{

	// Creates a BookRepo variable
	private BookRepo repo;
	
	public BookService(BookRepo repo) {
		this.repo = repo;
	}
	
	// Create a new book object	
	@Override
	public Book create(Book book) {
		return this.repo.save(book);
	}

	// Find all Book objects in list and displays them
	@Override
	public List<Book> readAll() {
		return this.repo.findAll();
	}

	// Find Book by its ID and displays it
	@Override
	public Book readById(long id) {
		Optional<Book> getBook = this.repo.findById(id);
		
		// Checks if an ID is present, if so then it display that book
		if(getBook.isPresent()) {
			return getBook.get();
		}
		return null;
	}

	// Updates the book information
	@Override
	public Book update(long id, Book book) {
		Optional<Book> existingBook = this.repo.findById(id);
		
		// If the book exists then it will set all the attributes besides ID
		if(existingBook.isPresent()) {
			Book exists = existingBook.get();
			exists.setName(book.getName());
			exists.setGenre(book.getGenre());
			exists.setRating(book.getRating());
			exists.setPrice(book.getPrice());
			
			// Saves the changes made and then flushes that information
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	// Deletes object by ID, then checks to see if it still exists by trying to return it
	// If it returns true then it has been successful
	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return false;
	}
}