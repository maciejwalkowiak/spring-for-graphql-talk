package com.example.starofjavagraphqltak;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarofjavaGraphqlTakApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarofjavaGraphqlTakApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(BookRepository bookRepository, AuthorRepository authorRepository) {
        return args -> {
            var author1 = authorRepository.save(new Author(null, "Joshua Bloch"));
            var author2 = authorRepository.save(new Author(null, "Mark Heckler"));
            bookRepository.save(new Book("Effective Java", 2001, author1));
            bookRepository.save(new Book("Spring Book Up & Running", 2021, author2));
        };
    }

}
