package com.example.librarymanagementstudent.repository;

import com.example.librarymanagementstudent.Enum.Gender;
import com.example.librarymanagementstudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByGender(Gender gender);

    // Student findByEmail(String email);

  //  Student findByGenderAndEmail(Gender gender, String email)  // return student because email is still unique
}
