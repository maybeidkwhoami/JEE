package com.example.tp2gestion.dao.repositories;

import com.example.tp2gestion.dao.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
