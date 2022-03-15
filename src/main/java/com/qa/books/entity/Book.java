package com.qa.books.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Book {

	// auto generate ID and puts into ID column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// name has to be a String and unique
	@Column(unique = true, nullable = false)
	private String name;
	
	@Column
	private String genre;
	
	@Column
	private int rating;
	
	@Column
	@Min(1)		// The price can only be a min of 1
	@Max(100)	// or a max of 100
	private double price;
	
	// Default Constructor
	public Book() {}

	// Constructor for Book object WITHOUT ID
	public Book(String name, String genre, int rating, @Min(1) @Max(100) double price) {
		super();
		this.name = name;
		this.genre = genre;
		this.rating = rating;
		this.price = price;
	}

	// Constructor for Book object WITH ID
	public Book(long id, String name, String genre, int rating, @Min(1) @Max(100) double price) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.rating = rating;
		this.price = price;
	}
	
	// Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// End of Getters and Setters
	
	// To String
	@Override
	public String toString() {
		return "Book [ID: " + id + ",\n"
				+ "Name: " + name + ",\n"
				+ "Genre: " + genre + ",\n"
				+ "Rating: " + rating + ",\n"
				+ "Price: " + price + "\n";
	}
	
	// Hash Code
	@Override
	public int hashCode() {
		return Objects.hash(genre, name, price, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(genre, other.genre) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) && rating == other.rating;
	}

}