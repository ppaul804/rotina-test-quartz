package br.com.ppaul804.rotinatestquartz.controller;

import br.com.ppaul804.rotinatestquartz.model.Book;
import br.com.ppaul804.rotinatestquartz.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }
}
