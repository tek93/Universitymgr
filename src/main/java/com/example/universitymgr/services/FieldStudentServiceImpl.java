package com.example.universitymgr.services;

import com.example.universitymgr.model.FieldStudent;
import com.example.universitymgr.repository.FieldRepository;
import com.example.universitymgr.repository.FieldStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FieldStudentServiceImpl implements FieldStudentService {
    @Autowired
    private FieldStudentRepository  fieldStudentRepository;

    @Override
    public FieldStudent saveFieldStudent(FieldStudent fieldStudent){
        return fieldStudentRepository.save(fieldStudent);
    }
    @Override
    public List<FieldStudent> findAllFieldStudent(Long studentId){
      return   fieldStudentRepository.findByStudentId(studentId);
    }
    @Override
    public List<FieldStudent> findAllStudentOfInstructor(Long instructorId){
        return fieldStudentRepository.findByFieldInstructorId(instructorId);
    }
    @Override
    public  List<FieldStudent> findAllEnrollments(){
        return fieldStudentRepository.findAll();
        
    }
}
