package com.qa.books.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.books.entity.Book;
import com.qa.books.service.BookService;

@SpringBootTest
public class BookControllerUnitTest {

	@Autowired
	private BookController controller;

	@MockBean
	private BookService service;

	@Test
	public void createBookTest() {

		Book book = new Book("My Hero Academia", "Shonen", 9, 7);

		Mockito.when(this.service.create(book)).thenReturn(book);

		ResponseEntity<Book> response = new ResponseEntity<Book>(book, HttpStatus.CREATED);

		assertThat(response).isEqualTo(this.controller.createBook(book));

		Mockito.verify(this.service, times(1)).create(book);
	}

	@Test
	public void readAllTest() {

		Book book = new Book("My Hero Academia", "Shonen", 9, 7);
		List<Book> bookList = new ArrayList<Book>();

		bookList.add(book);

		Mockito.when(this.service.readAll()).thenReturn(bookList);

		assertEquals(bookList, this.service.readAll());

		Mockito.verify(this.service, times(1)).readAll();
	}

	@Test
	public void readByIdTest() {

		Book book = new Book("My Hero Academia", "Shonen", 9, 7);

		Mockito.when(this.service.readById(Mockito.anyLong())).thenReturn(book);

		assertEquals(book, this.service.readById(Mockito.anyLong()));

		Mockito.verify(this.service, times(1)).readById(Mockito.anyLong());
	}

	@Test
	public void updateTest() {

		Book bookIn = new Book("My Hero Academia", "Shonen", 9, 7);
		Book bookOut = new Book(1L, "My Hero Academia", "Shonen", 9, 7);

		// Checks ID of bookIn, then returns bookOut
		Mockito.when(this.service.update(1L, bookIn)).thenReturn(bookOut);

		ResponseEntity<Book> response = new ResponseEntity<Book>(bookOut, HttpStatus.ACCEPTED);

		// Assert that checks that the response variable (defined above) is equal to
		// the controller updateBook method with the id 1L and the object bookIn
		assertThat(response).isEqualTo(this.controller.updateBook(1L, bookIn));

		Mockito.verify(this.service, Mockito.times(1)).update(1L, bookIn);
	}

	@Test
	public void deleteTest() {

		// Checks the ID of the object that is going to be deleted then returns true
		Mockito.when(this.service.delete(Mockito.anyLong())).thenReturn(true);

		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);

		// Checking that the response entity is the same as the response we get from the
		// method
		assertThat(response).isEqualTo(this.controller.deleteBook(1L));

		Mockito.verify(this.service, Mockito.times(1)).delete(Mockito.anyLong());
	}
}