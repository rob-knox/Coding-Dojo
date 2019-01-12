package com.robknox.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robknox.mvc.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	// JPA queries
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
}
