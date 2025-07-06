package com.library.repository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public String getBookTitle() {
        return "Effective Java";
    }
}
