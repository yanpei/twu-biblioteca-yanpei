package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;

import java.util.ArrayList;

public class BibliotecaService {
    private String welcomeMessage = "Hello, welcome to the Biblioteca!";
    private ArrayList<Book> allBooks = new ArrayList<Book>(){};

    public BibliotecaService() {
    }

    public BibliotecaService(ArrayList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public ArrayList<Book> listBooks() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (Book book :
                getAllBooks()) {
            if(!book.getIsCheckedOut()){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public boolean checkoutBook(String bookName) {
        Book book = getBookByName(bookName);
        if (book != null && !book.getIsCheckedOut()) {
            book.setIsCheckedOut(true);
            return true;
        }
        return false;
    }

    public Book getBookByName(String bookName){
        for (Book book : getAllBooks()) {
            if (book.getBookName().equals(bookName))
                return book;
        }
        return null;
    }

    public boolean returnBook(String bookName) {
        Book book = getBookByName(bookName);
        if(book != null && book.getIsCheckedOut()){
            book.setIsCheckedOut(false);
            return true;
        }
        return false;
    }
}
