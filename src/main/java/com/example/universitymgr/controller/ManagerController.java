package com.example.universitymgr.controller;

import com.example.universitymgr.model.Field;
import com.example.universitymgr.model.FieldStudent;
import com.example.universitymgr.model.User;
import com.example.universitymgr.services.FieldServiceImpl;
import com.example.universitymgr.services.FieldStudentService;
import com.example.universitymgr.services.FiledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    @Autowired
    private FieldStudentService fieldStudentService;
    private FieldServiceImpl fieldService;

    @GetMapping("/api/manager/enrollments")
    public ResponseEntity<?> findAllEnrollments(){
        return ResponseEntity.ok(fieldStudentService.findAllEnrollments());


    }
    @PostMapping("/api/manager/add")
    public ResponseEntity<Field> addNewFiled( @RequestBody Field field){
        return new  ResponseEntity<>(fieldService.addField(field), HttpStatus.CREATED);



    }

}
