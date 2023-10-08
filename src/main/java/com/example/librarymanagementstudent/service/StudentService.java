package com.example.librarymanagementstudent.service;

import com.example.librarymanagementstudent.Enum.CardStatus;
import com.example.librarymanagementstudent.Enum.Gender;
import com.example.librarymanagementstudent.dto.requestDTO.StudentRequest;
import com.example.librarymanagementstudent.dto.responseDTO.LibraryCardResponse;
import com.example.librarymanagementstudent.dto.responseDTO.StudentResponse;
import com.example.librarymanagementstudent.model.LibraryCard;
import com.example.librarymanagementstudent.model.Student;
import com.example.librarymanagementstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
//    public String addStudent(Student student) {
//        LibraryCard libraryCard = new LibraryCard();
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//        libraryCard.setStudent(student);
//
//        student.setLibraryCard(libraryCard );   // set librarycard for student
//
//       Student savedStudent = studentRepository.save(student);  // save both student and Library Card
//       return "Student saved successfully";
//    }

    public StudentResponse addStudent(StudentRequest studentRequest) {

        //covert request dto ->> model;
//        Student student = new Student();
//        student.setName(studentRequest.getName());
//        student.setAge(studentRequest.getAge());
//        student.setEmail(studentRequest.getEmail());
//        student.setGender(studentRequest.getGender());

        // create object using builder
        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();

        // give a library card
//        LibraryCard libraryCard = new LibraryCard();
//        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
//        libraryCard.setCardStatus(CardStatus.ACTIVE);
//        libraryCard.setStudent(student);

        LibraryCard libraryCard = LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .student(student)
                .build();

        student.setLibraryCard(libraryCard );   // set librarycard for student

        Student savedStudent = studentRepository.save(student);  // save both student and Library Card


        // saved model to response dto
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(savedStudent.getName());
        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setMessage("You have been registered");

        LibraryCardResponse cardResponse = new LibraryCardResponse();
        cardResponse.setCardNo(savedStudent.getLibraryCard().getCardNo());
        cardResponse.setIssueDate(savedStudent.getLibraryCard().getIssueDate());
        cardResponse.setCardStatus(savedStudent.getLibraryCard().getCardStatus());
        studentResponse.setLibraryCardResponse(cardResponse);

        return studentResponse;
    }

    public Student getStudent(int regNo) {   // If the primary key
        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public List<String> getAllMales() {

      List<String> names = new ArrayList<>();
      List<Student> students = studentRepository.findByGender(Gender.MALE);
      for(Student s: students){
          names.add(s.getName());
      }
      return names;
    }
}
