package ua.com.alevel.db;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;

public class DBWithCollectionsTest extends TestCase {
    @Before
    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setName("War and peace");
        DBWithCollections.getInstance().createBook(book);
    }
    @Before
    @Test
    public void testCreateAuthor() {
        Author author = new Author();
        author.setFamilyName("Tolstoy");
        author.setName("Lev");
        DBWithCollections.getInstance().createAuthor(author);
    }
    @Test
    public void testReadBook() {
        Book book = new Book();
        book.setName("War and peace");
        DBWithCollections.getInstance().createBook(book);
        DBWithCollections.getInstance().readBook(1);
    }
    @Test
    public void testReadAuthor() {
        Author author = new Author();
        author.setName("Lev");
        DBWithCollections.getInstance().createAuthor(author);
        DBWithCollections.getInstance().readAuthor(1);
    }
    public void testReadAllBooks() {
        Book book = new Book();
        DBWithCollections.getInstance().createBook(book);
        DBWithCollections.getInstance().readAllBooks();
    }
    public void testReadAllAuthors() {
        Author author = new Author();
        DBWithCollections.getInstance().createAuthor(author);
        DBWithCollections.getInstance().readAllAuthors();
    }

    public void testDeleteAuthor() {
        Author author = new Author();
        DBWithCollections.getInstance().createAuthor(author);
        DBWithCollections.getInstance().deleteAuthor(author.getId());
    }
    public void testDeleteBook() {
        Book book = new Book();
        DBWithCollections.getInstance().createBook(book);
        DBWithCollections.getInstance().deleteBook(book.getId());
    }
}