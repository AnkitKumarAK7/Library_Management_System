package com.example.librarymanagementstudent.dto.responseDTO;

import com.example.librarymanagementstudent.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookResponse {

    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;
}
