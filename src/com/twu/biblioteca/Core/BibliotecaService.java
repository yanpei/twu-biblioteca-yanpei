package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movies;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private String welcomeMessage = "Hello, welcome to the Biblioteca!";
    private ArrayList<Book> allBooks = new ArrayList<Book>(){
        {
            add(new Book("book 1","author 1",2016,false));
            add(new Book("book 2","author 2",2016,false));
        }
    };
    private List<Movies> allMovies = new ArrayList<Movies>(){
        {
            add(new Movies("movie 1",2016,"director 1",2));
        }
    };

    public BibliotecaService() {
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

    public List<Movies> listMovies() {
        return allMovies;
    }
}
