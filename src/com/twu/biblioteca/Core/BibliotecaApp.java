package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    String welcomeMessage = "Hello, welcome to the Biblioteca!";
    public ArrayList<Book> allBooks = new ArrayList<Book>();

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public List<Book> listBooks() {
        return allBooks;
    }
}
