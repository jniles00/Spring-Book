package com.qa.books.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.books.entity.Book;
import com.qa.books.repo.BookRepo;

@SpringBootTest
public class BookServiceUnitTesting {

	// Tells Spring to insert this object into the class
	@Autowired
	private BookService service;

	// Mocks the repository class because we don't want to rely on the class itself
	@MockBean
	private BookRepo repo;

	@Test
	public void createBookTest() {

		// Input does not have ID
		Book bookInput = new Book("Secret Invasion", "Action", 12, 15.99);
		// Input does have ID
		Book bookOutput = new Book(1, "Secret Invasion", "Action", 12, 15.99);

		// Testing the actually create method within the BookService class
		Mockito.when(this.repo.save(bookInput)).thenReturn(bookOutput);

		// Checking the expected value (bookOutput) is the same value
		// as the output when the create method is run
		assertEquals(bookOutput, this.service.create(bookInput));

		// Checks to make sure the repo is run 1 time before saving the input
		// (bookInput)
		Mockito.verify(this.repo, Mockito.times(1)).save(bookInput);
	}

	@Test
	public void readByIdTest() {

		// Optional is used because it is used within the readById method in the
		// BookService Class
		Optional<Book> optionalOutput = Optional.of(new Book("Secret Invasion", "Action", 12, 15.99));
		Book bookOutput = new Book(1, "Secret Invasion", "Action", 12, 15.99);

		// Mockito.anyLong() checks that the type of data used is a Long
		// regardless of the actual number
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);

		assertEquals(bookOutput, this.service.readById(Mockito.anyLong()));

		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}

	@Test
	public void readAll() {

		// Creating a list of Books
		List<Book> bookList = new ArrayList<Book>();
		Book bookOutput = new Book(1, "Secret Invasion", "Action", 12, 15.99);

		// Adding bookOutput to the list
		bookList.add(bookOutput);

		// Runs the find all
		Mockito.when(this.repo.findAll()).thenReturn(bookList);

		assertEquals(bookList, this.service.readAll());

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void updateTest() {

		Book bookInput = new Book("Secret Invasion", "Action", 12, 15.99);
		Book bookOutput = new Book(1, "Secret Invasion", "Action", 12, 15.99);
		Optional<Book> optionalOutput = Optional.of(new Book(1, "Bloodborne Graphic Novel", "Dark Fantasy", 18, 20));

		// Finds a book by its ID and then returns it as optionalOutput
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		Mockito.when(this.repo.saveAndFlush(bookInput)).thenReturn(bookOutput);

		assertEquals(bookOutput, this.service.update(Mockito.anyLong(), bookOutput));

		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(bookOutput);
	}

	@Test
	public void deleteTrueTest() {

		// Checks to see if an object with the specific ID is NOT there
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);

		// If it is there then it will delete that object
		assertTrue(this.service.delete(1L));
		
		// Deletes the object by ID
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		// Checks to see if it still exists via its ID
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
	@Test
	public void deleteFalseTest() {
		
		// Checks to see if an object with the specific ID IS there
		Mockito.when(this.repo.existsById(1L)).thenReturn(true);
		
		// If it is then it will delete it
		assertFalse(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
}