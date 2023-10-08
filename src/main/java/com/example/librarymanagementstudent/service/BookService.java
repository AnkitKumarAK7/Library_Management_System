package com.example.librarymanagementstudent.service;

import com.example.librarymanagementstudent.Enum.Genre;
import com.example.librarymanagementstudent.dto.requestDTO.BookRequest;
import com.example.librarymanagementstudent.dto.responseDTO.BookResponse;
import com.example.librarymanagementstudent.exception.AuthorNotFoundException;
import com.example.librarymanagementstudent.model.Author;
import com.example.librarymanagementstudent.model.Book;
import com.example.librarymanagementstudent.repository.AuthorRepository;
import com.example.librarymanagementstudent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;


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

//    public List<BookResponse> getBookByGenreAndCostGreaterThan(Genre genre, double cost) {
//        List<Book> books = bookRepository.getBookByGenreAndCostGreaterThanHQL(genre, cost);
//
//        // prepare a response convert model to dto
//
//        List<BookResponse> response = new ArrayList<>();
//
//        for(Book book: books){
//            BookResponse bookResponse = new BookResponse();
//            bookResponse.setTitle(book.getTitle());
//            bookResponse.setNoOfPages(book.getNoOfPages());
//            bookResponse.setGenre(book.getGenre());
//            bookResponse.setCost(book.getCost());
//            bookResponse.setAuthorName(book.getAuthor().getName());
//
//            response.add(bookResponse);
//
//        }
//      return response;
//    }

    public List<BookResponse> getBookByGenreAndCostGreaterThanHQL(Genre genre, double cost) {
        List<Book> books = bookRepository.getBookByGenreAndCostGreaterThanHQL(genre, cost);

        // prepare a response convert model to dto

        List<BookResponse> response = new ArrayList<>();

        for(Book book: books){
            BookResponse bookResponse = new BookResponse();
            bookResponse.setTitle(book.getTitle());
            bookResponse.setNoOfPages(book.getNoOfPages());
            bookResponse.setGenre(book.getGenre());
            bookResponse.setCost(book.getCost());
            bookResponse.setAuthorName(book.getAuthor().getName());

            response.add(bookResponse);

        }
        return response;
    }

//    public String addBook(BookRequest bookRequest) {
//
//        // covert request dto to model
//        Book book = new Book();
//        book.setTitle(bookRequest.getTitle());
//        book.setNoOfPages(bookRequest.getNoOfPages());
//        book.setGenre(bookRequest.getGenre());
//        book.setCost(bookRequest.getCost());
//
//
//        //Check if author exist or not
//        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
//        if(authorOptional.isEmpty()){
//            throw new AuthorNotFoundException("Invalid author id!!!");  // Custom Exception
//        }
//
//        Author author = authorOptional.get();
//        book.setAuthor(author);
//
//        author.getBooks().add(book);
//
//        Author authorSaved = authorRepository.save(author);   // this will save author and book
//
//        BookResponse bookResponse = new BookResponse();
//     //   bookResponse.setTitle(authorSaved.getBook().getTitle());
//        return "Book added Successfully";
//    }
}
