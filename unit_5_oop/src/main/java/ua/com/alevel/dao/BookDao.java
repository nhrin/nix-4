package ua.com.alevel.dao;

import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;
import ua.com.alevel.db.DBWithCollections;

import java.util.List;

public class BookDao {

    public void create(Book data) {
        DBWithCollections.getInstance().createBook(data);
    }

    public Book read(int id) {
        return DBWithCollections.getInstance().readBook(id);
    }

    public List<Book> read() {
        return DBWithCollections.getInstance().readAllBooks();
    }

    public void update(Book data) {
        DBWithCollections.getInstance().updateBook(data);
    }

    public void delete(int id) {
        DBWithCollections.getInstance().deleteBook(id);
    }
}
