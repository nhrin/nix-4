package ua.com.alevel.db;

import org.apache.log4j.Logger;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;

import java.util.ArrayList;
import java.util.List;

public class DBWithCollections {

    Logger logger = Logger.getLogger(DBWithCollections.class);
    private final List<Book> books = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();

    private static DBWithCollections instance;

    // private constructor
    private DBWithCollections() {
    }

    // very simple singletone
    public static DBWithCollections getInstance() {
        if (instance == null) {
            instance = new DBWithCollections();
        }
        return instance;
    }

    public void createBook(Book data) {
        int id = books.size() + 1;
        data.setId(id);
        books.add(data);
        logger.info("Book created");
    }

    public void createAuthor(Author data) {
        int id = authors.size() + 1;
        data.setId(id);
        authors.add(data);
        logger.info("Author created");
    }

    public Book readBook(int id) {
        logger.info("Read book by id");
        return books.stream()
                .filter(data -> data.getId() == id)
                .findFirst()
                .get();
           }
    public Author readAuthor(int id) {
       logger.info("Read author by id");
        return authors.stream()
                .filter(data -> data.getId() == id)
                .findFirst()
                .get();
    }
    public List<Book> readAllBooks() {
        logger.info("Read all books");
        return books;
    }
    public List<Author> readAllAuthors() {
        logger.info("Read all authors");
        return authors;
    }
    public void updateAuthor(Author author) {
        logger.info("User updated");
        Author current = readAuthor(author.getId());
        current.setFamilyName(author.getFamilyName());
        current.setName(author.getName());
    }
    public void updateBook(Book book) {
        logger.info("Book updated");
        Book current = readBook(book.getId());
        current.setName(book.getName());
    }
    public void deleteAuthor(int id) {
        logger.info("Author deleted");
        authors.removeIf(author -> author.getId() == id);
    }
    public void deleteBook(int id) {
        logger.info("Book deleted");
        books.removeIf(book -> book.getId() == id);
    }

}

