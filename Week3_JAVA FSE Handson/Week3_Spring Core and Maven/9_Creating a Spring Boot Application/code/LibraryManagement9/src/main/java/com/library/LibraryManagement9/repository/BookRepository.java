package com.library.LibraryManagement9.repository;

import com.library.LibraryManagement9.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
