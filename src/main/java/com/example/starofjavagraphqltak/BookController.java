package com.example.starofjavagraphqltak;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    List<BookDTO> books() {
        return ((List<Book>) bookRepository.findAll()).stream().map(BookDTO::fromBook).collect(Collectors.toList());
    }

    record BookDTO(Long id, String title, Integer publicationYear) {
        static BookDTO fromBook(Book book) {
            return new BookDTO(book.getId(), book.getTitle(), book.getPublicationYear());
        }
    }
}
