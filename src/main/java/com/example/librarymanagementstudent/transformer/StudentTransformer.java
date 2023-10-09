package com.example.librarymanagementstudent.transformer;

import com.example.librarymanagementstudent.dto.requestDTO.StudentRequest;
import com.example.librarymanagementstudent.dto.responseDTO.StudentResponse;
import com.example.librarymanagementstudent.model.Student;

public class StudentTransformer {

    public static Student StudentRequestToStudent(StudentRequest studentRequest){
        return  Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static Student StudentResponseToStudent(Student student){

    }
}
