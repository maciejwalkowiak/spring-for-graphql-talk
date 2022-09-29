package com.example.starofjavagraphqltak;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface BookRepository extends CrudRepository<Book, Long>, QuerydslPredicateExecutor<Book> {
    @Query("select b from Book b join fetch b.author")
    List<Book> findBooksWithAuthors();
}
