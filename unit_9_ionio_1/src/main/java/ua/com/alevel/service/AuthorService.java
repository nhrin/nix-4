package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.data.Author;

import java.util.List;

public class AuthorService {
    private final AuthorDao authorDao = new AuthorDao();

    public void create(Author data) {
        authorDao.create(data);
    }
    public List<Author> read() {
        if (authorDao.read().size() == 0) System.out.println("List of authors is empty");
        return authorDao.read();
    }
    public Author read(int id) {
        existAuthor(id);
        return authorDao.read(id);
    }
    public void update(Author author) {
        existAuthor(author.getId());
        authorDao.update(author);
    }
    public void delete(int id) {
        existAuthor(id);
        authorDao.delete(id);
    }

    private void existAuthor(int id) {
        Author author = authorDao.read(id);
        if (author == null) {
            throw new RuntimeException("404");
        }
    }

}
