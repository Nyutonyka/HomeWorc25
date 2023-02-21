package service.impl;

import entity.Student;
import org.junit.jupiter.api.Test;
import service.ConnectionClass;
import service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    ConnectionClass cc = new ConnectionClassImpl();
    Connection connection = cc.connect();
    Statement statement = cc.statement(connection);
    StudentService ss = new StudentServiceImpl();

    StudentServiceImplTest() throws SQLException {
    }

    @Test
    void addToDataBase() throws SQLException{
        boolean result = ss.addToDataBase(statement, "'Nik Kidman', 3, 2018");
        assertFalse(result);
    }

    @Test
    void deleteFromDataBase() throws SQLException {
        boolean result = ss.deleteFromDataBase(statement, "Full_name", "'Nik Kidman'");

        assertFalse(result);
    }

    @Test
    void getAll() throws SQLException {

        List<Student> student = ss.getAll(statement);

        assertEquals(student.get(0).getId(),1000);
        assertEquals(student.get(0).getFullName(),"Babich Anna");
        assertEquals(student.get(0).getIdClass(),1);
        assertEquals(student.get(0).getYearAdmission(),2020);

        assertNotEquals(student.size(), 16);

    }

    @Test
    void getByName() throws SQLException {
        List<Student> student = ss.getByName(statement, "'Babich Anna'");

        assertEquals(student.toString(),
                "[Student: id - 1000, Babich Anna, idClass - 1, year - 2020]");
        assertNotNull(student);


    }

    @Test
    void getByIds() throws SQLException {
        List<Student> student = ss.getByIds(statement, 1000);

        assertEquals(student.toString(),
                "[Student: id - 1000, Babich Anna, idClass - 1, year - 2020]");
        assertNotNull(student);

    }

    @Test
    void getByIdClass() throws SQLException {
        List<Student> student = ss.getByIdClass(statement, 1);

        assertEquals(student.size(), 4);
        assertNotNull(student);
    }
}