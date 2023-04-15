package HW5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class StudentTest {
    private Session session = null;
    private static String[][] students; // = {{"NameTest1","MarkTest1"}, {"NameTest2","MarkTest2"}};
    
    private Session createHibernateSession()
    {
        SessionFactory sessionFactory  = null;
        ServiceRegistry serviceRegistry = null;
        try {
            try {
                Configuration cfg = new Configuration().
                addResource("student.hbm.xml").configure();
                serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);
            } catch (Throwable e) {
                System.err.println("Failed to create sessionFactory object." + e);
                throw new ExceptionInInitializerError(e);
            }
            session = sessionFactory.openSession();
            System.out.println("Create session");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return session;
    }
    private void adds()
    {
        try {
            System.out.println("Add Rec to Table");
            Transaction tx = session.beginTransaction();
            for (int i = 0; i < 1000; i++) {
                Student student1 = new Student();
                student1.setName(students[i][1]);
                student1.setMark(students[i][1]);
                session.save(student1);
            }
            tx.commit();
            System.out.println("\tConfirm add");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void reads()
    {
        System.out.println("\nRead Rec from Table");
        String query = "select p from " + Student.class.getSimpleName() + " p";

        @SuppressWarnings("unchecked")
        List<Student> list = (List<Student>)session.createQuery(query).list();
        System.out.println(list);
    }

    private void recordFind(final int id)
    {
        System.out.println("\nRead Rec from Table to ID");
        Student student = (Student) session.load(Student.class, id);
        System.out.println(student);
    }

    public StudentTest(String[][] students)
    {
        this.students = students;
        // Создание сессии
        session = createHibernateSession();
        if (session != null) {
            // Добавление записей в таблицу
            adds();
            // Чтение записей таблицы
            reads();
            // Поиск записи по идентификатору
            recordFind(Integer.valueOf(this.students[1][0]));
            // Закрытие сессии
            if (session.isOpen())
                session.close();
        }
    }

    public static void main(String[] args)
    {
        new StudentTest(students);
        System.exit(0);
    }

}
