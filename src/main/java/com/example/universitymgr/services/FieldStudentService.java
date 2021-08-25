package com.example.universitymgr.services;

import com.example.universitymgr.model.FieldStudent;

import java.util.List;

public interface FieldStudentService {
    FieldStudent saveFieldStudent(FieldStudent fieldStudent);

    List<FieldStudent> findAllFieldStudent(Long studentId);

    List<FieldStudent> findAllStudentOfInstructor(Long instructorId);

    List<FieldStudent> findAllEnrollments();
}
