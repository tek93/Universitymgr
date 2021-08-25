package com.example.universitymgr.model;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "field_student")
public class FieldStudent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private User student;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    private Field field;
}
