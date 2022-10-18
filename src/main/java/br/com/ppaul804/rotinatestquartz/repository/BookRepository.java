package br.com.ppaul804.rotinatestquartz.repository;

import br.com.ppaul804.rotinatestquartz.model.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public int getBooksCount() {
        return books.size();
    }
}
