package com.qa.books.service;

import java.util.List;

public interface ServiceMethods<T> {

	// Create method - create object with T being any type
	T create(T book);
	
	// Read All method - reads all objects in a list
	List<T> readAll();
	
	// Read by ID - find object by ID
	T readById(long id);
	
	// Update method - find object by ID and updates it
	T update(long id, T book);
	
	// Delete method - delete object based on ID
	boolean delete(long id);
}