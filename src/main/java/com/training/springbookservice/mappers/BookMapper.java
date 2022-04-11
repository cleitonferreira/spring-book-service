package com.training.springbookservice.mappers;

import com.training.springbookservice.controllers.BookController;
import com.training.springbookservice.domain.Book;
import com.training.springbookservice.model.BookDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(uses = BookController.class)
public interface BookMapper {

    Book mapBookDTOAsBook( BookDTO bookDTO);

    BookDTO mapBookAsBookDTO(Book book);

    List<BookDTO> booksToBookDTOList(List<Book> bookList);
}
