package com.example.librarymanagementstudent.controller;

import com.example.librarymanagementstudent.Enum.Genre;
import com.example.librarymanagementstudent.dto.responseDTO.BookResponse;
import com.example.librarymanagementstudent.exception.AuthorNotFoundException;
import com.example.librarymanagementstudent.model.Book;
import com.example.librarymanagementstudent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // give me names of all the books of a particular genre and cost greater than x rs

//    @GetMapping("/get-by-genre-cost")
//    public List<BookResponse> getBookByGenreAndCostGreaterThan(@RequestParam("genre") String genre,
//                                                               @RequestParam("cost") double cost){
//          return bookService.getBookByGenreAndCostGreaterThan(genre, cost);
//    }

    @GetMapping("/get-by-genre-cost-HQL")
    public List<BookResponse> getBookByGenreAndCostGreaterThanHQL(@RequestParam("genre") Genre genre,
                                                               @RequestParam("cost") double cost){
        return bookService.getBookByGenreAndCostGreaterThanHQL(genre, cost);
    }

    // give all the books having number of pages between 'a' and 'b'

    // give me names of all the author who write a particular genre

}
