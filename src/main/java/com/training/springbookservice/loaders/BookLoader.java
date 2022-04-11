package com.training.springbookservice.loaders;

import com.training.springbookservice.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookLoader implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        /*var id1 = 1L;
        log.info("Calling bookRepository findById(1L)...");
        bookRepository.findById(id1).ifPresent(System.out::println);
        log.info("After Calling bookRepository findById(1L)");

        var id2 = 2L;
        var val = bookRepository.findById(id2);

        if (val.isPresent()) {
            System.out.println(val.get());
            log.info("Val 2l found: " + val.get());
        } else {
            System.out.printf("No city found with id %d%n", id2);
            log.info("Not found");
        }*/
    }

    private void loadBooks(){

    }
}
