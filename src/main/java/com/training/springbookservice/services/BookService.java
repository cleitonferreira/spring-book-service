package com.training.springbookservice.services;

import com.training.springbookservice.domain.Book;

import java.util.List;

public interface BookService {

    Book findByName(String name);

    Book findById(Long id);

    List<Book> findAll();

    Book save(Book book);

    Book update(Book book, Long id);

    void delete(Long id);
}
