package com.training.springbookservice.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super("Could not find Book with id " + id);
    }

    public BookNotFoundException(String name) {
        super("Could not find Book with name " + name);
    }
}
