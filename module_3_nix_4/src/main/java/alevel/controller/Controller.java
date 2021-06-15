package alevel.controller;

import alevel.dao.AccountDao;
import alevel.dao.CategoryDao;
import alevel.entity.Expense;
import alevel.entity.ExpenseCategory;
import alevel.entity.Income;
import alevel.entity.IncomeCategory;
import alevel.listener.DbConfig;
import alevel.logger.FinanceLogger;
import org.slf4j.Logger;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    static Income incomeOperation = new Income();
    static Expense expenseOperation = new Expense();
    private static Logger logger = FinanceLogger.getLogger();


    public static void addIncomeOperation(Long amount, String category, String username, String password, Long userId, Long acId) {
        AccountDao account = new AccountDao(username, password);
        CategoryDao incomeCategory = new CategoryDao(username, password);
        incomeOperation.setAmount(amount);
        incomeOperation.getCategories().add(incomeCategory.findIncomeByName(category));
        incomeOperation.setTimestamp(Instant.now(Clock.systemUTC()));
        if (account != null) {
            account.addOperationToCurrentUser(userId, acId, incomeOperation);
        }
    }

    public static void addExpenseOperation(Long amount, String category, String username, String password, Long userId, Long acId) {
        AccountDao account = new AccountDao(username, password);
        CategoryDao expenseCategory = new CategoryDao(username, password);
        DbConfig.configure(username, password);
        expenseOperation.setAmount(amount);
        expenseOperation.getCategories().add(expenseCategory.findExpenseByName(category));
        expenseOperation.setTimestamp(Instant.now(Clock.systemUTC()));
        if (account != null) {
            account.addOperationToCurrentUser(userId, acId, expenseOperation);
        }
    }

    public static void writeCSV(Long id, LocalDate from, LocalDate to, String username, String password) {
        AccountDao account = new AccountDao(username, password);
        account.getAccountStatementToCsv(id, from, to);
    }

    public static void showIncomeCategories(String name, String password) {
        CategoryDao categoryDao = new CategoryDao(name, password);
        List<IncomeCategory> list = categoryDao.getAllIncomeCategories();
        for (IncomeCategory i : list) {
            System.out.println(i.getName());
        }
    }

    public static void showExpenseCategories(String name, String password) {
        CategoryDao categoryDao = new CategoryDao(name, password);
        List<ExpenseCategory> list = categoryDao.getAllExpenseCategories();
        for (ExpenseCategory i : list) {
            System.out.println(i.getName());
        }
    }
}