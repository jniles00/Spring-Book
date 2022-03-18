package com.qa.books.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.books.entity.Book;
import com.qa.books.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	// Making the BookService class into a variable
	private BookService service;
	
	private BookController(BookService service) {
		this.service = service;
	}
	
	// Create - Used to create a book object
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return new ResponseEntity<Book>(this.service.create(book), HttpStatus.CREATED);
	}
	
	// Read All - Returns a list of all the books
	@GetMapping("/readAll")
	public ResponseEntity<List<Book>> readAll(){
		return new ResponseEntity<List<Book>>(this.service.readAll(), HttpStatus.OK);
	}
	
	// Read ID - Finds a book based on its ID
	@GetMapping("/readById/{id}")
	public ResponseEntity<Book> readById(@PathVariable long id){
		return new ResponseEntity<Book>(this.service.readById(id), HttpStatus.OK);
	}
	
	// Update - Changes the information of an existing book object
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable long id, @RequestBody Book book){
		return new ResponseEntity<Book>(this.service.update(id, book), HttpStatus.ACCEPTED);
	}
	
	// Delete - Finds the book by its ID and then deletes it
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable long id){
		
		// if the book object is successfully deleted then it will show "NO_CONTENT"
		return(this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT):
		//Else it will return "NOT_FOUND"
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
}