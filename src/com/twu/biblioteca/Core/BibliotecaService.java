package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    String welcomeMessage = "Hello, welcome to the Biblioteca!";
    public ArrayList<Book> allBooks = new ArrayList<Book>();

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public ArrayList<Book> listBooks() {
        return allBooks;
    }

    public boolean checkoutBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book != null && !book.isCheckedOut) {
            return true;
        }
        return false;
    }

    public Book getBookByName(String bookName){
        for (Book book :
                allBooks) {
            if (book.bookName == bookName)
                return book;
        }
        return null;
    }
}
