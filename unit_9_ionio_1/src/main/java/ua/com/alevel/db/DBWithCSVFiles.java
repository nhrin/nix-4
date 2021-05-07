package ua.com.alevel.db;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBWithCSVFiles {

    Logger logger = Logger.getLogger(DBWithCSVFiles.class);

    private int idAuthor = setAuthorsId();
    private int idBook = setBooksId();

    private static DBWithCSVFiles instance;

    // private constructor
    private DBWithCSVFiles() throws IOException {
    }


    // very simple singletone
    @SneakyThrows
    public static DBWithCSVFiles getInstance() {
        if (instance == null) {
            instance = new DBWithCSVFiles();
        }
        return instance;
    }

    @SneakyThrows
    public void createBook(Book data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("Books.csv", true))) {

            int id = ++idBook;
            data.setId(id);
            String[] toWrite = new String[]{Integer.toString(data.getId()), data.getName(), data.getAuthorsId().toString()};
            writer.writeNext(toWrite);
            logger.info("Book created");

        }
    }

    @SneakyThrows
    public void createAuthor(Author data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter("Authors.csv", true))) {
            int id = ++idAuthor;
            data.setId(id);
            String booksId = null;
            String[] toWrite = new String[]{Integer.toString(data.getId()), data.getName(), data.getFamilyName(), booksId};
            writer.writeNext(toWrite);
            logger.info("Author created");
        }
    }

    @SneakyThrows
    public Book readBook(int id) {
        logger.info("Read book by id");
        Book book = new Book();
        try (CSVReader reader = new CSVReader(new FileReader("Books.csv"))) {
            String[] stringOfData;
            while ((stringOfData = reader.readNext()) != null) {
                if (Integer.parseInt(stringOfData[0]) == id) {
                    book.setId(id);
                    book.setName(stringOfData[1]);
                    List<Integer> idsAuthors = new ArrayList<Integer>();

                    String[] arr = stringOfData[2].split(",");

                    for (String s : arr) {
                        idsAuthors.add(Integer.parseInt(s.replaceAll("[^0-9]", "")));
                    }
                    book.setAuthorsId(idsAuthors);

                } //else throw new NullPointerException();
            }
        }
        return book;
    }

    @SneakyThrows
    public Author readAuthor(int id) {
        logger.info("Read author by id");
        Author author = new Author();
        try (CSVReader reader = new CSVReader(new FileReader("Authors.csv"))) {
            String[] stringOfData;
            while ((stringOfData = reader.readNext()) != null) {
                if (Integer.parseInt(stringOfData[0]) == id) {
                    author.setId(id);
                    author.setName(stringOfData[1]);
                    author.setFamilyName(stringOfData[2]);
                } //else throw new NullPointerException();
            }
        }
        return author;
    }

    @SneakyThrows
    public List readAllBooks() {
        logger.info("Read all books");
        List<Book> list = new ArrayList();
        try (CSVReader reader = new CSVReader(new FileReader("Books.csv"), ',')) {
            String[] stringOfData;
            while ((stringOfData = reader.readNext()) != null) {
                Book book = new Book();
                book.setName(stringOfData[1]);
                book.setId(Integer.parseInt(stringOfData[0]));
                String[] arr = stringOfData[2].split(",");

                List<Integer> idsAuthors = new ArrayList<Integer>();
                for (String s : arr) {
                    idsAuthors.add(Integer.parseInt(s.replaceAll("[^0-9]", "")));
                }
                book.setAuthorsId(idsAuthors);
                list.add(book);
            }
        }

        return list;
    }


    @SneakyThrows
    public List<Author> readAllAuthors() {
        List<Author> list = new ArrayList();
        try (CSVReader reader = new CSVReader(new FileReader("Authors.csv"), ',')) {
            String[] stringOfData;
            while ((stringOfData = reader.readNext()) != null) {
                Author author = new Author();
                author.setName(stringOfData[1]);
                author.setFamilyName(stringOfData[2]);
                author.setId(Integer.parseInt(stringOfData[0]));
                list.add(author);
            }

            return list;
        }
    }

    @SneakyThrows
    public void updateAuthor(Author data) {
        logger.info("User updated");
        List<Author> authors = readAllAuthors();
        try (CSVWriter writer = new CSVWriter(new FileWriter("Authors.csv", false))) {
            authors.removeIf(author -> author.getId() == data.getId());
            for (Author author : authors) {
                String[] toWrite = new String[]{Integer.toString(author.getId()), author.getName(), author.getFamilyName()};
                writer.writeNext(toWrite);
            }
            String[] current = new String[]{Integer.toString(data.getId()), data.getName(), data.getFamilyName()};
            writer.writeNext(current);
        }
    }

    @SneakyThrows
    public void updateBook(Book data) {
        logger.info("Book updated");
        List<Book> books = readAllBooks();
        try (CSVWriter writer = new CSVWriter(new FileWriter("Books.csv", false))) {
            books.removeIf(book -> book.getId() == data.getId());
            for (Book book : books) {
                String[] toWrite = new String[]{Integer.toString(book.getId()), book.getName(), book.getAuthorsId().toString()};
                writer.writeNext(toWrite);
            }
            String[] current = new String[]{Integer.toString(data.getId()), data.getName(), data.getAuthorsId().toString()};
            writer.writeNext(current);
        }
    }

    @SneakyThrows
    public void deleteAuthor(int id) {
        logger.info("Author deleted");
        List<Author> authors = readAllAuthors();
        try (CSVWriter writer = new CSVWriter(new FileWriter("Authors.csv", false))) {
            authors.removeIf(book -> book.getId() == id);
            for (Author author : authors) {
                String[] toWrite = new String[]{Integer.toString(author.getId()), author.getName(), author.getFamilyName()};
                writer.writeNext(toWrite);
            }
        }
    }

    @SneakyThrows
    public void deleteBook(int id) {
        logger.info("Book deleted");
        List<Book> books = readAllBooks();
        try (CSVWriter writer = new CSVWriter(new FileWriter("Books.csv", false))) {
            books.removeIf(book -> book.getId() == id);
            for (Book book : books) {
                String[] toWrite = new String[]{Integer.toString(book.getId()), book.getName(), book.getAuthorsId().toString()};
                writer.writeNext(toWrite);
            }
        }
    }

    @SneakyThrows
    int setBooksId() {
        File file = new File("Books.csv");
        int res = 0;
        if (file.length() > 0) {
            res = readAllBooks().size();
        }
        return res;
    }

    @SneakyThrows
    int setAuthorsId() {
        File file = new File("Authors.csv");
        int res = 0;
        if (file.length() > 0) {
            res = readAllAuthors().size();
        }
        return res;
    }
}
