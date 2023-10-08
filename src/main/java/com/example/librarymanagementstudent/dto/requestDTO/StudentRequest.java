package com.example.librarymanagementstudent.dto.requestDTO;

import com.example.librarymanagementstudent.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class StudentRequest {

    String name;

    int age;

    String email;

    Gender gender;
}
