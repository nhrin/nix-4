package ua.com.alevel.db;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;

public class DBWithCSVFilesTest extends TestCase {
    @Before
    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setName("War and peace");
        DBWithCSVFiles.getInstance().createBook(book);
    }
    @Before
    @Test
    public void testCreateAuthor() {
        Author author = new Author();
        author.setFamilyName("Tolstoy");
        author.setName("Lev");
        DBWithCSVFiles.getInstance().createAuthor(author);
    }
    @Test
    public void testReadBook() {
        Book book = new Book();
        book.setName("War and peace");
        DBWithCSVFiles.getInstance().createBook(book);
        DBWithCSVFiles.getInstance().readBook(1);
    }
    @Test
    public void testReadAuthor() {
        Author author = new Author();
        author.setName("Lev");
        DBWithCSVFiles.getInstance().createAuthor(author);
        DBWithCSVFiles.getInstance().readAuthor(1);
    }
    public void testReadAllBooks() {
        Book book = new Book();
        DBWithCSVFiles.getInstance().createBook(book);
        DBWithCSVFiles.getInstance().readAllBooks();
    }
    public void testReadAllAuthors() {
        Author author = new Author();
        DBWithCSVFiles.getInstance().createAuthor(author);
        DBWithCSVFiles.getInstance().readAllAuthors();
    }

    public void testDeleteAuthor() {
        Author author = new Author();
        DBWithCSVFiles.getInstance().createAuthor(author);
        DBWithCSVFiles.getInstance().deleteAuthor(author.getId());
    }
    public void testDeleteBook() {
        Book book = new Book();
        DBWithCSVFiles.getInstance().createBook(book);
        DBWithCSVFiles.getInstance().deleteBook(book.getId());
    }
}