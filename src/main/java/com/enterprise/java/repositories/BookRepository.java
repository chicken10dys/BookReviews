package com.enterprise.java.repositories;

import com.enterprise.java.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// Repository for books
@RepositoryRestResource(path = "books")
public interface BookRepository extends JpaRepository<Book, Integer> {
}
