package com.example.librarymanagementstudent.dto.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class StudentResponse {

    String name;

    String email;

    String message;

    String cardIssuedNo;

    public void setLibraryCardResponse(LibraryCardResponse cardResponse) {
    }
}
