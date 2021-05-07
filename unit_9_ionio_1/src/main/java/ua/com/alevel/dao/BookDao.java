package ua.com.alevel.dao;

import ua.com.alevel.data.Book;
import ua.com.alevel.db.DBWithCSVFiles;

import java.util.List;

public class BookDao {

    public void create(Book data) {
        DBWithCSVFiles.getInstance().createBook(data);
    }

    public Book read(int id) {
        return DBWithCSVFiles.getInstance().readBook(id);
    }

    public List read() {
        return DBWithCSVFiles.getInstance().readAllBooks();
    }

    public void update(Book data) {
        DBWithCSVFiles.getInstance().updateBook(data);
    }

    public void delete(int id) {
        DBWithCSVFiles.getInstance().deleteBook(id);
    }
}
