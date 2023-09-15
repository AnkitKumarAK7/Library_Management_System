package com.example.librarymanagementstudent.service;

import com.example.librarymanagementstudent.Enum.CardStatus;
import com.example.librarymanagementstudent.model.LibraryCard;
import com.example.librarymanagementstudent.model.Student;
import com.example.librarymanagementstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public String addStudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard );   // set librarycard for student

       Student savedStudent = studentRepository.save(student);  // save both student and Library Card
       return "Student saved successfully";
    }

    public Student getStudent(int regNo) {   // If the primary ke y
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
