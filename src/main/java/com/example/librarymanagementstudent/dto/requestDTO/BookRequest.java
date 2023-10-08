package com.example.librarymanagementstudent.dto.requestDTO;

import com.example.librarymanagementstudent.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookRequest {

    String title;

    int noOfPages;

    Genre genre;

    double cost;

}
