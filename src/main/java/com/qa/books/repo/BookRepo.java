package com.qa.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.books.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{
	
}