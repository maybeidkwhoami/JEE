package com.example.tp2gestion.dao.repositories;

import com.example.tp2gestion.dao.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository <Professor, Integer> {
}
