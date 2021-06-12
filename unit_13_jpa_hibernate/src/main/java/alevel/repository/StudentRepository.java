package alevel.repository;

import alevel.entity.Student;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentRepository {

    public StudentRepository() {

    }

    public Student findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Student.class, id);
    }

    public List<Student> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("From Student").list();
            return students;
        }
    }

    public void save(Student students) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(students);
            t.commit();
        }
    }
}
