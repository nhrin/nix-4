package ua.com.alevel.service;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.data.Book;

import java.util.List;

public class BookService {
    private final BookDao bookDao = new BookDao();

    public void create(Book data) {
        bookDao.create(data);
    }
    public List<Book> read() {
        if (bookDao.read().size() == 0) System.out.println("List of authors is empty");
        return bookDao.read();
    }
    public Book read(int id) {
        existBook(id);
        return bookDao.read(id);
    }
    public void update(Book book) {
        existBook(book.getId());
        bookDao.update(book);
    }
    public void delete(int id) {
        existBook(id);
        bookDao.delete(id);
    }

    private void existBook(int id) {
        Book book = bookDao.read(id);
        if (book == null) {
            throw new RuntimeException("404");
        }
    }
}
