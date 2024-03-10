package com.example.tp2gestion.dao.repositories;

import com.example.tp2gestion.dao.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Integer> {
}
