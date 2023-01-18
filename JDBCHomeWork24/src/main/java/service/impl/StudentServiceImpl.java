package service.impl;

import dto.Student;
import service.StudentService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean addToDataBase(Statement statement, String values) throws SQLException {
        return statement.execute("insert into students " +
                "(Full_name, Class, Year_admission) " +
                "values (" + values + ")");
    }

    @Override
    public boolean deleteFromDataBase(Statement statement, String column, String values) throws SQLException{
        return statement.execute("delete from students where " +
                column + "=" + values);
    }

    @Override
    public List<Student> getAll(Statement statement) throws SQLException {
        ResultSet rs = statement.executeQuery("select * from students");
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String fullName = rs.getString("Full_name");
            int idClass = rs.getInt("Class");
            int yearAdmission = rs.getInt("Year_admission");
            student.add(new Student(id, fullName, idClass, yearAdmission));
        }
        return student;
    }

    @Override
    public List<Student> getByName(Statement statement, String name) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select * from students where Full_name = " + name);
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String fullName = rs.getString("Full_name");
            int idClass = rs.getInt("Class");
            int yearAdmission = rs.getInt("Year_admission");
            student.add(new Student(id, fullName, idClass, yearAdmission));
        }
        return student;
    }

    @Override
    public List<Student> getByIds(Statement statement, int ids) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select * from students where ID_student = " + ids);
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String fullName = rs.getString("Full_name");
            int idClass = rs.getInt("Class");
            int yearAdmission = rs.getInt("Year_admission");
            student.add(new Student(id, fullName, idClass, yearAdmission));
        }
        return student;
    }

    public List<Student> getByIdClass(Statement statement, int idc) throws SQLException {
        ResultSet rs = statement.executeQuery
                ("select * from students where Class = " + idc);
        List<Student> student = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID_student");
            String fullName = rs.getString("Full_name");
            int idClass = rs.getInt("Class");
            int yearAdmission = rs.getInt("Year_admission");
            student.add(new Student(id, fullName, idClass, yearAdmission));
        }
        return student;
    }
}
