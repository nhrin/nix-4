package alevel.repository;

import alevel.entity.Course;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CourseRepository {

    public CourseRepository() {
    }

    public Course findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Course.class, id);
    }


    public Course findByLecturerId(Long lecturerId) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            LecturerRepository lecturerRepository = new LecturerRepository();

            Query query = session.createQuery("from Course where lecturer = :lecturerId");
            query.setParameter("lecturerId", lecturerRepository.findById(lecturerId));
            Course course = (Course) query.getSingleResult();

            return course;
        }
    }

    public void save(Course course) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(course);
            t.commit();
        }
    }
}
