package alevel.repository;

import alevel.entity.Group;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {

    public GroupRepository() {
    }

    public Group findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Group.class, id);
    }

    public List<Group> findAllByCourseId(Long courseId) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {

            CourseRepository courseRepository = new CourseRepository();
            Query query = session.createQuery("from Group where course = :courseId");
            query.setParameter("courseId", courseRepository.findById(courseId));
            List<Group> groups = query.list();

            return groups;
        }
    }


    public List<Group> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Group> groups = session.createQuery("From Group").list();
            return groups;
        }
    }

    public void save(Group group) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(group);
            t.commit();
        }
    }
}
