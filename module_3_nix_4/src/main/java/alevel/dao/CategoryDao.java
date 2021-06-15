package alevel.dao;

import alevel.listener.DbConfig;
import alevel.entity.ExpenseCategory;
import alevel.entity.IncomeCategory;
import org.hibernate.Session;

import java.util.List;


public class CategoryDao {
    private static Session session;

    public CategoryDao(String name, String password) {
        session = DbConfig.configForHibernate(name, password).openSession();
    }

    public List<IncomeCategory> getAllIncomeCategories() {
        return session.createCriteria(IncomeCategory.class).list();
    }
    public List<ExpenseCategory> getAllExpenseCategories() {
        return session.createCriteria(ExpenseCategory.class).list();
    }

    public IncomeCategory findIncomeByName(String name) {
        return session.byNaturalId(IncomeCategory.class).using("name", name).getReference();
    }

    public ExpenseCategory findExpenseByName(String name) {
        return session.byNaturalId(ExpenseCategory.class).using("name", name).getReference();
    }
}
