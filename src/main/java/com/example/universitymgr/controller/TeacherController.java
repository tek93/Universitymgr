package com.example.universitymgr.controller;

import com.example.universitymgr.model.Field;
import com.example.universitymgr.model.User;
import com.example.universitymgr.services.FieldStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    @Autowired
    private FieldStudentService fieldStudentService;
    @GetMapping("/api/teacher/students/{teacherId}")
    public ResponseEntity<?> findAllStudentOfInstructor(@PathVariable Long teacherId){
        List<User> students = fieldStudentService.findAllStudentOfInstructor(teacherId).stream().map(cs->cs.getStudent()).collect(Collectors.toList());
        return  new ResponseEntity<>(students, HttpStatus.OK);



    }
}
