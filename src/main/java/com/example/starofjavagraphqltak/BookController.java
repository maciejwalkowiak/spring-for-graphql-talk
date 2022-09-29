package com.example.starofjavagraphqltak;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @BatchMapping
    Map<Book, String> price(List<Book> books) {
        throw new RuntimeException("foo");
    }

    @MutationMapping
    Book addBook(@Argument("book") BookInput bookInput) {
        var author = authorRepository.findById(bookInput.authorId()).get();
        var book = new Book(bookInput.title, bookInput.publicationYear(), author);
        return bookRepository.save(book);
    }

    record BookInput(String title, Integer publicationYear, Long authorId) {}
}
