package service.impl;

import hillel.entity.Student;
import hillel.service.impl.StudentServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hillel.service.StudentService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anna Babich
 * @version 1.0.0
 *
 * @since version 1.0.0
 */

class StudentServiceImplTest {

    private static StudentService ss = new StudentServiceImpl();

    @Test
    void addToDataBase(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = new Student("Anna", "Babich", 2, 2010);

        ss.addToDataBase(session, student);

        Assertions.assertEquals(1L, student.getId());

        session.close();
        sessionFactory.close();
    }

    @Test
    void deleteFromDataBase() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = new Student("Ben", "Babich", 2, 2010);
        ss.addToDataBase(session, student);

        Student student1 = (Student) session.get( Student.class, 1L );
        System.out.println( "Retrieved person from DB is " + student1 );

        ss.deleteFromDataBase(session, 1L);

        Student student2 = (Student) session.get( Student.class, 1L );
        System.out.println( "Retrieved person from DB after deletion is " + student2 );

        Assertions.assertNull(student2);

        session.close();
        sessionFactory.close();
    }

    @Test
    void getAll(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student1 = new Student("Anna", "Babich", 1, 2010);
        Student student2 = new Student("Ben", "Babich", 2, 2010);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        List<Student> students = ss.getAll(session);

        Assertions.assertEquals(2, students.size());
        Assertions.assertEquals(1, students.get(0).getId());
        Assertions.assertEquals("Anna", students.get(0).getName());
        Assertions.assertEquals(1, students.get(0).getIdClass());
        Assertions.assertEquals(2010, students.get(0).getYearAdmission());

        assertNotEquals( 16, students.size());

        session.close();
        sessionFactory.close();
    }

    @Test
    void getByName(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student1 = new Student("Anna", "Babich", 1, 2010);
        Student student2 = new Student("Ben", "Babich", 2, 2010);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        List<Student> students = ss.getByName(session, "Anna");

        Assertions.assertEquals(1, students.size());
        Assertions.assertEquals(1, students.get(0).getId());
        Assertions.assertEquals("Anna", students.get(0).getName());
        Assertions.assertEquals(1, students.get(0).getIdClass());
        Assertions.assertEquals(2010, students.get(0).getYearAdmission());

        List<Student> students1 = ss.getByName(session, "Ben");

        Assertions.assertEquals(1, students1.size());
        Assertions.assertEquals(2, students1.get(0).getId());
        Assertions.assertEquals("Ben", students1.get(0).getName());
        Assertions.assertEquals(2, students1.get(0).getIdClass());
        Assertions.assertEquals(2010, students1.get(0).getYearAdmission());

        session.close();
        sessionFactory.close();
    }

    @Test
    void getByIds(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student1 = new Student("Anna", "Babich", 1, 2010);
        Student student2 = new Student("Ben", "Babich", 2, 2010);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        Student s = ss.getByIds(session, 1L);
        Student s1 = ss.getByIds(session, 2L);

        Assertions.assertEquals(1, s.getId());
        Assertions.assertEquals(2, s1.getId());

        session.close();
        sessionFactory.close();
    }
}