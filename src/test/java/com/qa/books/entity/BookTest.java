package com.qa.books.entity;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BookTest {

	@Test
	public void testEquals() {
		
		EqualsVerifier.forClass(Book.class).usingGetClass().verify();
	}
	
	// Testing the getters and setters
	@Test
	public void getAndSetTest() {
		
		// Creates an empty book object
		Book book = new Book();
		
		// Uses the setters to method to add values to each variable
		book.setId(1);
		book.setName("Jojo's Bizarre Adventure");
		book.setGenre("Adventure, Horror");
		book.setRating(15);
		book.setPrice(7.99);
		
		// Checks to make sure that the values set above are not null
		assertNotNull(book.getId());
		assertNotNull(book.getName());
		assertNotNull(book.getGenre());
		assertNotNull(book.getRating());
		assertNotNull(book.getPrice());
		
		// Checks to make sure that the getter is getting the correct values
		assertEquals(book.getId(), 1);
		assertEquals(book.getName(), "Jojo's Bizarre Adventure");
		assertEquals(book.getGenre(), "Adventure, Horror");
		assertEquals(book.getRating(), 15);
		assertEquals(book.getPrice(), 7.99);
	}
	
	// Another test
	public void allArgsConstructor() {
		
		Book book = new Book(1, "Jojo's Bizarre Adventure", "Adventure, Horror", 15, 7.99);
		
		assertNotNull(book.getId());
		assertNotNull(book.getName());
		assertNotNull(book.getGenre());
		assertNotNull(book.getRating());
		assertNotNull(book.getPrice());
		
		assertEquals(book.getId(), 1);
		assertEquals(book.getName(), "Jojo's Bizarre Adventure");
		assertEquals(book.getGenre(), "Adventure, Horror");
		assertEquals(book.getRating(), 15);
		assertEquals(book.getPrice(), 7.99);
	}
}