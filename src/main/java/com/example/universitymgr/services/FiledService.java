package com.example.universitymgr.services;

import com.example.universitymgr.model.Field;

import java.util.List;

public interface FiledService {
    Field addField(Field field);

    Field updateField(Field field);

    void deleteField(Long fieldId);

    List<Field> findAllField();
}
