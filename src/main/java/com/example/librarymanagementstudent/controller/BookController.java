package com.example.librarymanagementstudent.controller;

import com.example.librarymanagementstudent.exception.AuthorNotFoundException;
import com.example.librarymanagementstudent.model.Book;
import com.example.librarymanagementstudent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook (@RequestBody Book book){

        try {
            String response = bookService.addBook(book);
            return response;
        }
        catch (AuthorNotFoundException e){
            return e.getMessage();
        }
    }

    // delete a book

    // give me name of all the books of a particular Genre

    // give me names of all the books of a particular genre and cost greater than 500 rs

    // give all the books having number of pages between 'a' and 'b'

    // give me names of all the author who write a particular genre

}
