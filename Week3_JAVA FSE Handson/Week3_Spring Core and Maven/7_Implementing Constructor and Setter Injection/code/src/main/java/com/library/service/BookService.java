package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;
    private String serviceName;

    // Constructor Injection
    public BookService(String serviceName) {
        this.serviceName = serviceName;
    }

    // Setter Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBook() {
        System.out.println("Service: " + serviceName);
        System.out.println("Book: " + bookRepository.getBookTitle());
    }
}
