package com.example.librarymanagementstudent.service;

import com.example.librarymanagementstudent.exception.AuthorNotFoundException;
import com.example.librarymanagementstudent.model.Author;
import com.example.librarymanagementstudent.model.Book;
import com.example.librarymanagementstudent.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    public String addBook(Book book) {

        //Check if author exist or not
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id!!!");  // Custom Exception
        }

        Author author = authorOptional.get();
        book.setAuthor(author);

        author.getBooks().add(book);

        authorRepository.save(author);   // this will save author and book
        return "Book added successfully";
    }
}
