package com.example.tp2gestion.dao.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Setter @Getter @ToString
@NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;


    @OneToOne
    private Professor courseGivenByProfessor;

    @OneToMany(mappedBy = "sessionCourse")
    private Collection<Session> SessionList = new ArrayList<>();
}
