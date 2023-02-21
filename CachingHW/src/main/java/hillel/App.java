package hillel;

import hillel.entity.Student;
import hillel.service.StudentService;
import hillel.service.impl.HibernateUtil;
import hillel.service.impl.StudentServiceImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = new Student("Ben", "Babich");
        Student student1 = new Student("Anna", "Babich");
        Student student2 = new Student("Don", "Babich");

        StudentService ss = new StudentServiceImpl();
        ss.addToDataBase(session, student);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        Query query = session.createQuery("FROM HIBERNATE_DEVELOPERS");
        System.out.println(query);
        query.setCacheable(true);
        query.setCacheRegion("developer");
        List developers = query.list();

        System.out.println(developers);

        session.close();
    }
}
