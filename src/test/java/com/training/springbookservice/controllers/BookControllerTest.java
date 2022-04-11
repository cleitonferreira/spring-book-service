/*
package com.training.springbookservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.springbookservice.domain.Book;
import com.training.springbookservice.services.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookService bookService;

    @Autowired
    ObjectMapper objectMapper;

    private List<Book> books;

    private Book book;

    @BeforeEach
    void setUp() {
        books = new ArrayList<>();
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
        book = Book.builder()
                .id(3l)
                .name("Madame Bovary")
                .genre("Drama")
                .writer("Gustave Flaubert")
                .year("1856")
                .build();
    }


@Test
    void testGetAllBooks() throws Exception {
        given(bookService.findAll()).willReturn(books);

        mockMvc.perform(get("/api/v1/bookService/books"))
                        .andExpect(status().isOk());

    }

@Test
    void testFindBookById() throws Exception {
        given(bookService.findById(book.getId())).willReturn(book);

        mockMvc.perform(get("api/v1/bookService/books" +
                book.getId()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }



    @Test
    void testFindBookByName() {
    }

    @Test
    void testSaveBook() throws Exception {

        //        beerDto.setId(null);
        //        Beer newBeer = Beer.builder().id(UUID.randomUUID()).beerName("Amstel").build();
        //        String beerToJson = objectMapper.writeValueAsString(beerDto);
                 Book newBook = Book.builder()
                .id(4l).genre("Horror")
                .name("Carry").writer("Stephen King")
                .year("1976").build();

        String bookToJson = objectMapper.writeValueAsString(book);
        given(bookService.save(any())).willReturn(newBook);

        mockMvc.perform(post("/api/v1/bookService/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bookToJson))
                .andExpect(status().isCreated());

    }

    @Test
    void testUpdateBook() {
    }

    @Test
    void testDeleteBook() {
    }
}
*/