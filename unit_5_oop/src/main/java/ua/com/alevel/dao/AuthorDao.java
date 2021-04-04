package ua.com.alevel.dao;

import ua.com.alevel.data.AbstractData;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;
import ua.com.alevel.db.DBWithCollections;

import java.util.List;

public class AuthorDao  {

    public void create(Author data) {
        DBWithCollections.getInstance().createAuthor(data);
    }

    public Author read(int id) {
        return DBWithCollections.getInstance().readAuthor(id);
    }

    public List<Author> read() {
        return DBWithCollections.getInstance().readAllAuthors();
    }

    public void update(Author data) {
        DBWithCollections.getInstance().updateAuthor(data);
    }

    public void delete(int id) {
        DBWithCollections.getInstance().deleteAuthor(id);
    }
}
