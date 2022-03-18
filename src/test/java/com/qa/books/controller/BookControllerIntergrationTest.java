package com.qa.books.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.books.entity.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Using RANDOM_PORT selects a random port to run the test on
@AutoConfigureMockMvc 										 // Creates the MockMvc object
@ActiveProfiles("test") 									 // Sets the current profile to "test"
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:book-schema.sql",
		"classpath:book-data.sql" })
public class BookControllerIntergrationTest {

	@Autowired
	private MockMvc mvc;									// Object for running the fake requests
	
	@Autowired
	private ObjectMapper mapper;
	
	// Test to make sure a new book can be created
	@Test
	public void testCreate() throws Exception{
		
		// Create new book object
		Book testBook = new Book(1, "Berserk", "Adventure", 18, 50);
		// Converts the book object into a String
		String testBookAsJSon = this.mapper.writeValueAsString(testBook);
		
		RequestBuilder req = post("/book/create").content(testBookAsJSon).contentType(MediaType.APPLICATION_JSON);
		
		Book testSavedBook = new Book(1, "Berserk", "Adventure", 18, 50); 
		String testSavedBookAsJSon = this.mapper.writeValueAsString(testSavedBook);
		
		//Checks the status code of the response
		ResultMatcher checkStatus = status().isCreated();
		
		// Checks the body of the response
		ResultMatcher checkBody = content().json(testSavedBookAsJSon);
		
		// runs the request and checks both matchers are correct
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	// Tests to see if the book entered within the book-data.sql file is the same as the one in the list
	@Test
	public void testReadAll() throws Exception{
		
		Book testBook = new Book(1, "Jojos Bizarre Adventure", "Fabulous", 10, 7);
		List<Book> bookList = new ArrayList<Book>();
		
		bookList.add(testBook);
		
		String testBookListAsJSon = this.mapper.writeValueAsString(bookList);
		
		this.mvc.perform(get("/book/readAll").contentType(MediaType.APPLICATION_JSON))
											 .andExpect(status().isOk())
											 .andExpect(content().json(testBookListAsJSon));
	}
	
	// Tests to see if a book can be found via its ID
	@Test
	public void testReadById() throws Exception{
		
		RequestBuilder req = get("/book/readById/1");
		
		ResultMatcher checkStatus = status().isOk();
		
		Book testBook = new Book(1, "Jojos Bizarre Adventure", "Fabulous", 10, 7);
		String testBookAsJSon = this.mapper.writeValueAsString(testBook);
		
		ResultMatcher checkBody = content().json(testBookAsJSon);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);	
		}
	
	// Test to check that a book object can be updated and information returned
	@Test
	public void testUpdate() throws Exception{
		
		Book testBook = new Book(1L, "Jojos Bizarre Adventure", "Fabulous", 10, 7);
		String testBookAsJSon = this.mapper.writeValueAsString(testBook);
		
		Book updateBook = new Book(1L, "My Hero Academia", "Shonen", 9, 7);
		String updateBookAsJSon = this.mapper.writeValueAsString(updateBook);
		
		this.mvc.perform(get("/book/readById/1")).andDo(print());
		
		
		this.mvc.perform(put("/book/update/1").contentType(MediaType.APPLICATION_JSON)
							 .content(updateBookAsJSon))
							 .andExpect(status().isAccepted())
							 .andExpect(content().json(updateBookAsJSon));
			
//		RequestBuilder reqUpdate = put("/book/update/1").contentType(MediaType.APPLICATION_JSON).content(testBookAsJSon);
//		ResultMatcher checkStatus = status().isAccepted()
//		ResultMatcher checkBody = content().json(updateBookAsJSon);
//		this.mvc.perform(reqUpdate).andExpect(checkStatus).andExpect(checkBody);
	}
	
	// Test to delete a book object
	@Test
	public void testDelete() throws Exception {
	
		RequestBuilder req = delete("/book/delete/1").contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isNoContent();
			
		this.mvc.perform(req).andExpect(checkStatus);
	}
}