package com.example.librarymanagementstudent.service;

import com.example.librarymanagementstudent.model.Author;
import com.example.librarymanagementstudent.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
       Author savedAuthor = authorRepository.save(author);
       return "Author successfully added";
    }
}
