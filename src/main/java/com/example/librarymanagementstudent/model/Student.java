package com.example.librarymanagementstudent.model;

import com.example.librarymanagementstudent.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity  // To tell JPA this is a Model class
@Table(name ="student_info")  // If we change the table name in the mid this is never happen it will create a new table
@Builder

public class Student {

    @Id    // To tell that this is primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // Automatically Generated regNo by Database
    int regNo;

    // @Column(name = "student_name")  // If we want to change the column name But it will not modify the column name it will create new
    String name;

    int age;

    @Column(unique = true, nullable = false)
    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)   // Student to LibraryCard
    LibraryCard libraryCard;
}
