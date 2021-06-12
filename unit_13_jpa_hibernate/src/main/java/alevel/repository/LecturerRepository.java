package alevel.repository;

import alevel.entity.Lecturer;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LecturerRepository {

    public LecturerRepository() {
    }

    public Lecturer findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Lecturer.class, id);
    }

    public void save(Lecturer lecturers) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(lecturers);
            t.commit();
        }
    }
}
