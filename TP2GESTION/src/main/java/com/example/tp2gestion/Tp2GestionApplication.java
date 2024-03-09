package com.example.tp2gestion;

import com.example.tp2gestion.dao.entities.Course;
import com.example.tp2gestion.dao.entities.Professor;
import com.example.tp2gestion.dao.entities.Session;
import com.example.tp2gestion.dao.entities.Student;
import com.example.tp2gestion.dao.repositories.CourseRepository;
import com.example.tp2gestion.dao.repositories.ProfessorRepository;
import com.example.tp2gestion.dao.repositories.SessionRepository;
import com.example.tp2gestion.dao.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;



@SpringBootApplication
public class Tp2GestionApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Tp2GestionApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        try {
            // Instanciation d'objet
            Course course = new Course();
            Professor professor = new Professor();
            Session session = new Session();
            Student student = new Student();

            // Remplissage des objets
            course.setTitre("JEE");
            course.setDescription("TP Spring Data JPA");

            professor.setName("Prof1");
            professor.setD_affectation("01/09/24");

            session.setDate("09/04/24");
            session.setStartTime(session.getDate()+" 08:30");
            session.setEndTime(session.getDate()+ " 12:45");

            student.setName("KAMOUSS Mohamed Amine");
            student.setMatricule("Matricule1");

            // Associations
            course.setCourseGivenByProfessor(professor);
            professor.setCourseToGive(course);
            session.setSessionCourse(course);
            session.getStudentsList().add(student);
            student.getSessionList().add(session);

            // Saving entities
            courseRepository.save(course);
            professorRepository.save(professor);
            sessionRepository.save(session);
            studentRepository.save(student);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
