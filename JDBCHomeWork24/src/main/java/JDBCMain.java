import dto.JoinStudent;
import dto.Student;
import service.ConnectionClass;
import service.DBService;
import service.Joins;
import service.StudentService;
import service.impl.ConnectionClassImpl;
import service.impl.DBServiceImpl;
import service.impl.StudentServiceImpl;

import java.sql.*;
import java.util.List;

/**
 * @author Anna Babich
 * @version 1.0.2
 *
 * @since version 1.0.0
 */

public class JDBCMain {

    public static void main(String[] args) throws SQLException {

        StudentService ss = new StudentServiceImpl();
        DBService dbs = new DBServiceImpl();
        ConnectionClass cc = new ConnectionClassImpl();

        Connection connection = cc.connect();
        Statement statement = cc.statement(connection);

        String data = """
                create table graduates (
                    id int not null auto_increment,
                    id_students int not null,
                    Name_class varchar(255) not null,
                    primary key (id),
                    foreign key (id_students) references students(ID_student))""";
        System.out.println(dbs.createTable(statement, data));

        String name = "graduates";
        System.out.println(dbs.deleteTable(statement, name));

        String nameTable = "students";
        dbs.infoTable(statement, nameTable);
        nameTable = "class";
        dbs.infoTable(statement, nameTable);

        Joins joins =  Joins.LEFT;
        List<JoinStudent> studentJL = dbs.getJoin(statement, joins);
        for (Student s : studentJL)
            System.out.println(s);
        System.out.println(studentJL.size());

        List<Student> students = ss.getAll(statement);
        for (Student s : students)
            System.out.println(s);
        System.out.println(students.size());

        List<Student> student = ss.getByName(statement,"'Babich Anna'");
        for (Student s : student)
            System.out.println(s);
        System.out.println(student.size());

        List<Student> studentId = ss.getByIds(statement, 1005);
        for (Student s : studentId)
            System.out.println(s);
        System.out.println(studentId.size());

        List<Student> studentIdClass = ss.getByIdClass(statement, 2);
        for (Student s : studentIdClass)
            System.out.println(s);
        System.out.println(studentIdClass.size());

        cc.closeConnect(connection);
    }
}
