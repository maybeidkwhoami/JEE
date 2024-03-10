package com.example.tp2gestion.dao.repositories;

import com.example.tp2gestion.dao.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student, Integer> {
}
