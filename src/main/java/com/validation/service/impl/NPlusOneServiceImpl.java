package com.validation.service.impl;

import com.validation.model.Author;
import com.validation.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NPlusOneServiceImpl {

    @Autowired
    private AuthorRepository authorRepository;

    public String findAllAuthor() {
//        List<Author> authors = authorRepository.findAll();
        List<Author> authors = authorRepository.findAllWithBooks();
//        List<Author> authors = authorRepository.findAllWithBooksUsingJoinFetch();
        for (Author author : authors) {
            log.info("Author: {}", author.getName());
            log.info("Books: {}", author.getBooks());
        }
        // n+1 == 1 - auther ,
        return "Done";
    }
}
