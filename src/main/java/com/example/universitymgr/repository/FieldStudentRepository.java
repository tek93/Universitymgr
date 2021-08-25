package com.example.universitymgr.repository;

import com.example.universitymgr.model.FieldStudent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FieldStudentRepository  extends JpaRepository<FieldStudent, Long> {

    List<FieldStudent> findByFieldInstructorId(Long instructorId);
    List<FieldStudent>findByStudentId(Long studentId);
}

