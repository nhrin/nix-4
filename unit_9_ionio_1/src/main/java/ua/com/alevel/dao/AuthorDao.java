package ua.com.alevel.dao;

import ua.com.alevel.data.Author;
import ua.com.alevel.db.DBWithCSVFiles;

import java.util.List;

public class AuthorDao  {

    public void create(Author data) {
        DBWithCSVFiles.getInstance().createAuthor(data);
    }

    public Author read(int id) {
        return DBWithCSVFiles.getInstance().readAuthor(id);
    }

    public List<Author> read() {
        return DBWithCSVFiles.getInstance().readAllAuthors();
    }

    public void update(Author data) {
        DBWithCSVFiles.getInstance().updateAuthor(data);
    }

    public void delete(int id) {
        DBWithCSVFiles.getInstance().deleteAuthor(id);
    }
}
