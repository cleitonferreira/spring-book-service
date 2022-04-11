package com.training.springbookservice.repositories;

import com.training.springbookservice.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository  extends JpaRepository<Book, Long> {
    Book findByName(String name);
}
