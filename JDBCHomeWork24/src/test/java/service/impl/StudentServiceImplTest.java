package service.impl;

import dto.Student;
import service.ConnectionClass;
import service.StudentService;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceImplTest {

    @org.junit.jupiter.api.Test
    void addToDataBase() {

    }

    @org.junit.jupiter.api.Test
    void deleteFromDataBase() {
    }

    @org.junit.jupiter.api.Test
    void getAll() throws SQLException {
        ConnectionClass cc = new ConnectionClassImpl();
        Connection connection = cc.connect();
        Statement statement = cc.statement(connection);
        StudentService ss = new StudentServiceImpl();

        List<Student> student = ss.getAll(statement);

        assertEquals(student.size(), 17);
        assertEquals(student.get(0).getId(),1000);
        assertEquals(student.get(0).getFullName(),"Babich Anna");
        assertEquals(student.get(0).getIdClass(),1);
        assertEquals(student.get(0).getYearAdmission(),2020);

    }

    @org.junit.jupiter.api.Test
    void getByName() {
    }

    @org.junit.jupiter.api.Test
    void getByIds() {
    }

    @org.junit.jupiter.api.Test
    void getByIdClass() {
    }
}