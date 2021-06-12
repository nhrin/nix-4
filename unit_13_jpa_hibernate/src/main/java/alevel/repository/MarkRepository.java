package alevel.repository;

import alevel.entity.Mark;
import alevel.listener.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MarkRepository {

    public MarkRepository() {
    }

    public Mark findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Mark.class, id);
    }

    public double countAvgMarkOfGroup(Long groupId) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            GroupRepository groupRepository = new GroupRepository();
            Query query = session.createQuery("select avg(mark) from Mark " +
                    "where group = :groupId group by group");
            query.setParameter("groupId", groupRepository.findById(groupId));
            Object obj = query.uniqueResult();
            double mark = Double.parseDouble(obj.toString());

            return mark;
        }
    }

    public List<Mark> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Mark> marks = session.createQuery("From Mark").list();
            return marks;
        }
    }

    public void save(Mark marks) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(marks);
            t.commit();
        }
    }
}
