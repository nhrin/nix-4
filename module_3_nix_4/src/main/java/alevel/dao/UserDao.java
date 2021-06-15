package alevel.dao;

import alevel.entity.User;
import alevel.logger.FinanceLogger;
import alevel.listener.DbConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;


public class UserDao {
    private static Session session;
    private Logger logger = FinanceLogger.getLogger();

    public UserDao(String name, String password) {
        session = DbConfig.configForHibernate(name, password).openSession();
    }

    public User findById(Long id) {
        return session.get(User.class, id);
    }

    public void update(User user) {
        Transaction beginTransaction = session.beginTransaction();
        try {
            session.update(user);
            beginTransaction.commit();
        } catch (Exception e) {
            beginTransaction.rollback();
        }
    }
}
