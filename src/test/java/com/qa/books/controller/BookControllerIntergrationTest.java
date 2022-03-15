package com.qa.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	
}