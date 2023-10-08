package com.example.librarymanagementstudent.repository;

import com.example.librarymanagementstudent.Enum.Genre;
import com.example.librarymanagementstudent.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query(value = "select * from book where genre = :genre and cost > :cost", nativeQuery = true)  // when we writing a normal SQl query then we write nativeQuery = true;
//    List<Book> getBookByGenreAndCostGreaterThan(String genre, double cost);

    @Query(value = "select b from Book b where b.genre = :genre and b.cost = :cost")
    List<Book> getBookByGenreAndCostGreaterThanHQL(Genre genre, double cost);
}
