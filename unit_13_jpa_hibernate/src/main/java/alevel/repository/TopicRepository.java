package alevel.repository;

import alevel.entity.Topic;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TopicRepository {

    public TopicRepository() {
    }

    public Topic findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Topic.class, id);
    }

    public List<Topic> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Topic> topics = session.createQuery("From Topic").list();
            return topics;
        }
    }

    public void save(Topic topics) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(topics);
            t.commit();
        }
    }
}
