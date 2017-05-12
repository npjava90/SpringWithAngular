package org.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.demo.model.Book;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class BookController {
	static List<Book> bookList = new ArrayList<>();
	static Book s1 = null;
	static Book s2 = null;
	static Book s3 = null;

	static {
		s1 = new Book();

		s1.setId("1");
		s1.setName("Don Quixote by Miguel de Cervantes");
		s1.setIsbn("12");

		s2 = new Book();

		s2.setId("2");
		s2.setName("In Search of Lost Time by Marcel Proust");
		s2.setIsbn("44");

		s3 = new Book();

		s3.setId("3");
		s3.setName("Ulysses by James Joyce");
		s3.setIsbn("33");

		bookList.add(s1);
		bookList.add(s2);
		bookList.add(s3);

	}

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks() {

		return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<Void> addBook(@RequestBody Book Student, UriComponentsBuilder builder) {

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/book/{id}").buildAndExpand(Student.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value="/book/{id}", method = RequestMethod.PUT ) 
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
	  
	return new   ResponseEntity<Book>(book, HttpStatus.OK);
	 
	}

	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
