package com.training.springbookservice.services;

import com.training.springbookservice.domain.Book;
import com.training.springbookservice.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@Slf4j
public class BookServiceTest {

    @MockBean
    BookRepository bookRepository;

    @Autowired
    BookService bookService;

    @Test
    void testFindById() {

        Book book = getBook();

        given(bookRepository.findById(1L)).willReturn(Optional.of(book));

        final Optional<Book> expectedBook = Optional.of(bookService.findById(book.getId()));
        assertEquals(expectedBook,Optional.of(book));
        assertNotNull(expectedBook);

    }

    @Test
    void testFindByName() {
        given(bookRepository.findByName("Harry Potter"))
                .willReturn(Book.builder()
                        .id(2L)
                        .name("Harry Potter")
                        .genre("Fantastic")
                        .writer("J. K. Rowling")
                        .year("1997")
                        .build()
        );

        Book book = Book.builder()
                .id(2L)
                .name("Harry Potter")
                .genre("Fantastic")
                .writer("J. K. Rowling")
                .year("1997")
                .build();
        final Book expectedBook = bookService.findByName("Harry Potter");
        assertEquals(expectedBook,book);
        assertNotNull(expectedBook);
    }

    @Test
    void testFindAll() {
        List<Book> books = new ArrayList<>();
        books.add(Book.builder()
                .name("Madame Bovary")
                .genre("Drama")
                .writer("Gustave Flaubert")
                .year("1856")
                .build());

        books.add(Book.builder()
                .name("Methamorphosis")
                .genre("Horror")
                .writer("Franz Kafka")
                .year("1856")
                .build());

            given(bookRepository.findAll()).willReturn(books);

            List<Book> expectedBooks = bookService.findAll();
            assertEquals(expectedBooks,books);
    }

    @Test
    void testSave() {
        Book book = Book.builder()
                .name("Crime and Punishment")
                .genre("Crime Fiction")
                .writer("Fyodor Dostoevsky")
                .year("1866")
                .build();

        given(bookRepository.findByName(book.getName())).willReturn(book);
        //given(bookRepository.save(book)).willAnswer(invocation -> invocation.getArguments().length);
        given(bookRepository.save(book)).willReturn(book);

        Book bookToSave = bookService.save(book);
        assertNotNull(bookToSave);

        verify(bookRepository).save(any(Book.class));
    }

    @Test
    void testUpdate() {
        Book book = Book.builder()
                .id(3l)
                .name("Crime and Punishment")
                .genre("Crime Fiction")
                .writer("Fyodor Dostoevsky")
                .year("1866")
                .build();

        given(bookRepository.save(book)).willReturn(book);

        Book bookToSave = bookService.save(book);
        log.info("Book just saved: " + bookToSave.toString());

       final Book expectedBook = bookService.update(book,book.getId());
        assertNotNull(expectedBook);
    }

    @Test
    void delete() {
        Book book = getBook();

        given(bookRepository.findById(1L)).willReturn(Optional.of(book));

        bookService.delete(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }

    private Book getBook(){
        return Book.builder()
                .id(1L)
                .name("Frankenstein")
                .genre("SCI-FI")
                .writer("Mary Shelley")
                .year("1968")
                .build();
    }
}