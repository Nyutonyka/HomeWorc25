package service.impl;

import entity.Student;
import lombok.extern.slf4j.Slf4j;
import service.StudentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Anna Babich
 * @version 1.0.2
 *
 * @since version 1.0.0
 */
@Slf4j
public class StudentServiceImpl implements StudentService {

    /**
     *
     * @param statement static SQL statement
     * @param values data student (Full_name, Class, Year_admission)
     *
     */
    @Override
    public boolean addToDataBase(Statement statement, String values) throws SQLException {
        return statement.execute("insert into students " +
                "(Full_name, Class, Year_admission) " +
                "values (" + values + ")");
    }

    /**
     *
     * @param statement static SQL statement
     * @param column name column from Table students
     * @param values data from colum on Table
     *
     */
    @Override
    public boolean deleteFromDataBase(Statement statement, String column, String values) throws SQLException{
        return statement.execute("delete from students where " +
                column + "=" + values);
    }

    /**
     *
     * @param statement static SQL statement
     *
     */
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

    /**
     *
     * @param statement static SQL statement
     * @param name full name student
     *
     */
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

    /**
     *
     * @param statement static SQL statement
     * @param ids identification student
     *
     */
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

    /**
     *
     * @param statement static SQL statement
     * @param idc identification class
     *
     */
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
