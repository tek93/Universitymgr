package com.example.universitymgr.controller;

import com.example.universitymgr.model.Field;
import com.example.universitymgr.model.FieldStudent;
import com.example.universitymgr.services.FieldStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private FieldStudentService fieldStudentService;

    @GetMapping("/api/student/fields/{studentId}")
    public ResponseEntity<?>findAllFieldOfStudent(@PathVariable Long studentId){
        List<Field>fieldList = fieldStudentService.findAllFieldStudent(studentId).stream().map(cs->cs.getField()).collect(Collectors.toList());
        return new ResponseEntity<>(fieldList, HttpStatus.OK);

    }
    @PostMapping("/api/student/enroll")
    public ResponseEntity<?>enroll(@RequestBody FieldStudent fieldStudent){
        return new ResponseEntity<>(fieldStudentService.saveFieldStudent(fieldStudent), HttpStatus.CREATED);

    }

}
