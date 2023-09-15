package com.example.librarymanagementstudent.controller;

import com.example.librarymanagementstudent.model.Author;
import com.example.librarymanagementstudent.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorService.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.CREATED);
   }

   // update the email id of an author --> observe lastActivity column

    // Give me the names of all the books written by a particular author

    // give me the names of author who have written more than 'x' number of books
}
