package com.example.universitymgr.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Data
@Entity
@Table(name = "field")
public class Field implements Serializable {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
   @Column(name = "name")
   private String name;
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "instructor_id", referencedColumnName = "id")
   private User instructor;


}
