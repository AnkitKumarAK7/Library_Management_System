package com.example.librarymanagementstudent.controller;

import com.example.librarymanagementstudent.dto.requestDTO.StudentRequest;
import com.example.librarymanagementstudent.dto.responseDTO.StudentResponse;
import com.example.librarymanagementstudent.service.StudentService;
import com.example.librarymanagementstudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")  // to give a common endpoint to all the APIs
public class StudentController {

    @Autowired
    StudentService studentService;

//    @PostMapping("/add")
//    public ResponseEntity addStudent(@RequestBody Student student){
//         String response = studentService.addStudent(student);
//         return new ResponseEntity(response, HttpStatus.CREATED);
//    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest){
         StudentResponse response = studentService.addStudent(studentRequest);
         return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.FOUND);
        }
       return new ResponseEntity("Invalid id!", HttpStatus.BAD_REQUEST);
    }


    // delete a student --> regNo

    // update the age of a student --> regNo, age

    // get all the student in the db

    // get list of all male students

    @GetMapping("/get-males")
       public List<String> getAllMales(){
        List<String> males = studentService.getAllMales();
        return males;
    }
}
