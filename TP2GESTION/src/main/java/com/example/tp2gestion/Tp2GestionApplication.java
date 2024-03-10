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
import java.util.ArrayList;
import java.util.List;


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
            Course course1 = new Course();
            Professor professor1 = new Professor();
            Session session1 = new Session();
            Student student1 = new Student();

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


            course1.setTitre("BIG DATA");
            course1.setDescription("Introduction to big data");

            professor1.setName("Prof2");
            professor1.setD_affectation("02/09/24");

            session1.setDate("08/04/24");
            session1.setStartTime(session.getDate()+" 16:15");
            session1.setEndTime(session.getDate()+ " 18:15");

            student1.setName("MOUCHRIF Ayoub");
            student1.setMatricule("Matricule2");

            // Associations
            course.setCourseGivenByProfessor(professor);
            professor.setCourseToGive(course);
            session.setSessionCourse(course);
            course1.setCourseGivenByProfessor(professor1);
            professor1.setCourseToGive(course1);
            session1.setSessionCourse(course1);
            session.getStudentsList().add(student);
            session.getStudentsList().add(student1);
            session1.getStudentsList().add(student);
            session1.getStudentsList().add(student1);
            student.getSessionList().add(session);
            student.getSessionList().add(session1);
            student1.getSessionList().add(session);
            student1.getSessionList().add(session1);

            // Saving entities
            courseRepository.save(course);
            courseRepository.save(course1);
            professorRepository.save(professor);
            professorRepository.save(professor1);
            sessionRepository.save(session);
            sessionRepository.save(session1);
            studentRepository.save(student);
            studentRepository.save(student1);


            //Update

            Course courseUpdateById = courseRepository.findById(2).get();
            courseUpdateById.setTitre("BigData and BOO/NoSQL");
            courseRepository.save(courseUpdateById);
            studentRepository.deleteById(2);

            courseRepository.deleteById(1);













        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
