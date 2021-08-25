package com.example.universitymgr.services;

import com.example.universitymgr.model.Field;
import com.example.universitymgr.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
@Service
@Transactional
public class FieldServiceImpl implements FiledService {
    @Autowired
    private FieldRepository fieldRepository;
    @Override
    public Field addField(Field field){
        return fieldRepository.save(field);

    }
    @Override
    public Field updateField(Field field){
        return fieldRepository.save(field);
    }
    @Override
    public void deleteField(Long fieldId){
        fieldRepository.deleteById(fieldId);
    }
    @Override
    public List<Field>findAllField(){
        return fieldRepository.findAll();
    }
}
