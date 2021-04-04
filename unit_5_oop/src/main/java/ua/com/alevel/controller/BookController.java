package ua.com.alevel.controller;

import lombok.SneakyThrows;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookController {
    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();
    private final AuthorController authorController = new AuthorController();

    @SneakyThrows
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose operation ");
        System.out.println("1 - create");
        System.out.println("2 - read all books");
        System.out.println("3 - read book");
        System.out.println("4 - update");
        System.out.println("5 - delete");
        String position;
        while ((position = reader.readLine()) != null) {
            switch (position) {
                case "up": {
                    MainController mainController = new MainController();
                    mainController.run();
                    break;
                }
                case "0": {
                    System.exit(0);
                }
                case "1":
                    create(reader);
                    break;
                case "2":
                    read();
                    break;
                case "3":
                    readBook(reader);
                    break;
                case "4":
                    update(reader);
                    break;
                case "5":
                    delete(reader);
                    break;
            }
            System.out.println("Your variant: repeat logic with book or enter \"up\" for change object");
        }
        reader.close();
    }

    @SneakyThrows
    private void create(BufferedReader reader) {
        System.out.println("Enter book's name ...");
        Book book = new Book();
        String name = reader.readLine();
        String position;
        System.out.println("Choose authors (enter his id for adding), enter 7 when you finish, press enter for start");
        authorController.read();
        List<Integer> list = new ArrayList<>();
        while (!(position = reader.readLine()).equals("7")) {
            System.out.println("please enter your id or \"7\" ...");
            int id = Integer.parseInt(position);
            list.add(id);
        }
        book.setName(name);
        book.setAuthorsId(list);
        bookService.create(book);
    }

    @SneakyThrows
    private void update(BufferedReader reader) {
        try {
            System.out.println("please enter your id ...");
            String idS = reader.readLine();
            int id = Integer.parseInt(idS);
            Book book = bookService.read(id);
            System.out.println("Enter book's name ...");
            String name = reader.readLine();
            book.setName(name);
            bookService.update(book);
        } catch (NoSuchElementException e) {
            System.out.println("Wrong ID!!!");
            update(reader);
        }
    }

    @SneakyThrows
    private void delete(BufferedReader reader) {
        try {
            System.out.println("please enter your id ...");
            String idS = reader.readLine();
            int id = Integer.parseInt(idS);
            bookService.delete(id);
        } catch (NoSuchElementException e) {
            System.out.println("Wrong ID!!!");
            delete(reader);
        }
    }

    private void read() {
        try {
            bookService.read().stream()
                    .forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("No info about authors");
        }
    }

    @SneakyThrows
    private void readBook(BufferedReader reader) {
        System.out.println("please enter your id ...");
        String idS = reader.readLine();
        int id = Integer.parseInt(idS);


        try {
            System.out.println(bookService.read(id));
            for (int i : bookService.read(id).getAuthorsId()) {
                for (Author author : authorService.read()) {
                    if (i == author.getId()) {
                        System.out.println(author);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No info about books");
        } catch (NoSuchElementException e) {
            System.out.println("Wrong ID!!!");
            readBook(reader);
        }
    }

}
