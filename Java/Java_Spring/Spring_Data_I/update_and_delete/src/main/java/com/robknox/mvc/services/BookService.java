package com.robknox.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robknox.mvc.models.Book;
import com.robknox.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	private Book book;
	
	// Dependency Injection
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}
	
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	
	// updates a book
	public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return bookRepository.save(book);
		} else {
			return null;
		}
	}
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
		
	// delete a book
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}

}
