package com.validation.repository;

import com.validation.model.Author;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    //1. solution for fix n+1 problem - using EntityGraph
    @Query("SELECT a FROM Author a")
    @EntityGraph(attributePaths = {"books"})
    List<Author> findAllWithBooks();

  // 2. using join fetch
      @Query("SELECT a FROM Author a JOIN FETCH a.books")
      List<Author> findAllWithBooksUsingJoinFetch();

}
