import entity.Student;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.StudentService;
import service.impl.HibernateUtil;
import service.impl.StudentServiceImpl;

/**
 * @author Anna Babich
 * @version 1.0.0
 *
 * @since version 1.0.0
 */

public class Main {

    private static final Logger logger = LoggerFactory.getLogger("stdout");

    public static void main(String[] args){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Student student = new Student("Ben", "Babich", 2, 2010);
        Student student1 = new Student("Anna", "Babich", 2, 2010);
        Student student2 = new Student("Don", "Babich", 2, 2010);

        StudentService ss = new StudentServiceImpl();
        ss.addToDataBase(session, student);
        ss.addToDataBase(session, student1);
        ss.addToDataBase(session, student2);

        ss.deleteFromDataBase(session, 3L);

        Student studentId = ss.getByIds(session, 1L);
        logger.info(String.valueOf(studentId));

        ss.getAll(session);

        ss.getByName(session, "Anna");

        session.close();
    }
}
