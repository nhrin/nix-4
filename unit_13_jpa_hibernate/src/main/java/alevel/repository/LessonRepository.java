package alevel.repository;

import alevel.entity.Course;
import alevel.entity.Lesson;
import alevel.entity.Student;
import alevel.listener.HibernateSessionFactory;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class LessonRepository {

    private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public LessonRepository() {
    }

    @SneakyThrows
    public Lesson findNextLesson(Student student, Instant currentDate) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            session.beginTransaction();
            Instant current = currentDate;
            Long courseId = student.getGroup().getId();
            Query query = session.createQuery("from Lesson where dateAndTime > :current and course.id = :courseId" +
                    " order by dateAndTime");
            query.setParameter("current", current);
            query.setParameter("courseId", courseId);
            Lesson lesson = (Lesson) query.list().get(0);
            session.getTransaction().commit();
            return lesson;
        }

    }

    public Lesson findById(Long id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Lesson.class, id);
    }

    public List<Lesson> findAll() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Lesson> lessons = session.createQuery("From Lesson").list();
            return lessons;
        }
    }

    public void save(Lesson lessons) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction t = session.beginTransaction();
            session.save(lessons);
            t.commit();
        }
    }
}
