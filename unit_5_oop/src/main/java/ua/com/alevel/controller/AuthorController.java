package ua.com.alevel.controller;

import lombok.SneakyThrows;
import ua.com.alevel.data.Author;
import ua.com.alevel.data.Book;
import ua.com.alevel.service.AuthorService;
import ua.com.alevel.service.BookService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

public class AuthorController {
    private final AuthorService authorService = new AuthorService();
    private final BookService bookService = new BookService();

    @SneakyThrows
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Choose operation ");
        System.out.println("1 - create");
        System.out.println("2 - read all authors");
        System.out.println("3 - read author");
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
                case "1":
                    create(reader);
                    break;
                case "2":
                    read();
                    break;
                case "3":
                    readAuthor(reader);
                    break;
                case "4":
                    update(reader);
                    break;
                case "5":
                    delete(reader);
                    break;
            }
            System.out.println("Your variant: repeat logic with author or enter \"up\" for change object");
        }
        reader.close();
    }

    @SneakyThrows
    private void create(BufferedReader reader) {
        System.out.println("Enter author's name ...");
        Author author = new Author();
        String name = reader.readLine();
        System.out.println("Enter author's family name ...");
        String familyName = reader.readLine();
        author.setName(name);
        author.setFamilyName(familyName);
        authorService.create(author);
    }

    @SneakyThrows
    private void update(BufferedReader reader) {
        try {
            System.out.println("please enter your id ...");
            String idS = reader.readLine();
            int id = Integer.parseInt(idS);
            Author author = authorService.read(id);
            System.out.println("Enter author's name ...");
            String name = reader.readLine();
            System.out.println("Enter author's family name ...");
            String email = reader.readLine();
            author.setName(name);
            author.setFamilyName(email);
            authorService.update(author);
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
            authorService.delete(id);
        } catch (NoSuchElementException e) {
            System.out.println("Wrong ID!!!");
            delete(reader);
        }
    }

    void read() {
        try {
            authorService.read().stream()
                    .forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("No info about books");
        }

    }

    @SneakyThrows
    private void readAuthor(BufferedReader reader) {
        System.out.println("please enter your id ...");
        String idS = reader.readLine();
        int id = Integer.parseInt(idS);
        try {
            System.out.println(authorService.read(id));
            for (int i : authorService.read(id).getBooksId()) {
                for (Book book : bookService.read()) {
                    if (i == book.getId()) {
                        System.out.println(book);
                    }
                }
            }
        } catch (NullPointerException e) {
            System.out.println("No info about books");
        } catch (NoSuchElementException e) {
            System.out.println("Wrong ID!!!");
            readAuthor(reader);
        }
    }

}
