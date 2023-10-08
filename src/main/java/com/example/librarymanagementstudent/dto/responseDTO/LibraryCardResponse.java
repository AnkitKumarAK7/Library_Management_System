package com.example.librarymanagementstudent.dto.responseDTO;

import com.example.librarymanagementstudent.Enum.CardStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class LibraryCardResponse {

    String cardNo;

    CardStatus cardStatus;

    Date issueDate;
}
