package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Resources.Repository;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private String welcomeMessage = "Hello, welcome to the Biblioteca!";
    private User loginUser;
    private ArrayList<Book> allBooks;
    private List<Movie> allMovies;
    private ArrayList<User> users;

    public BibliotecaService(Repository repository){
        this.allBooks = repository.getAllBooks();
        this.allMovies = repository.getAllMovies();
        this.users = repository.getUsers();
    }

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    public String getWelcomeMessage() {

        return welcomeMessage;
    }

    public ArrayList<Book> getAllBooks() {

        return allBooks;
    }

    public ArrayList<User> getUsers() {
        return users;
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
            book.setCheckoutUser(loginUser);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        Book book = getBookByName(bookName);
        if(book != null && book.getIsCheckedOut() && book.getCheckoutUser() == loginUser){
            book.setIsCheckedOut(false);
            book.setCheckoutUser(null);
            return true;
        }
        return false;
    }

    public List<Movie> listMovies() {
        return allMovies;
    }

    public boolean checkoutMovie(String movieName) {
        for (Movie movie:
             allMovies) {
            if(movie.getName().equals(movieName)){
                return true;
            }
        }
        return false;
    }

    public boolean login(String loginMessage) {
        String libraryNumber = loginMessage.split(",")[0];
        String password = loginMessage.split(",")[1];

        for (User user:
             users) {
            if(user.getLibraryNumber().equals(libraryNumber)){
                if(user.getPassword().equals(password)){
                    user.setLogin(true);
                    loginUser = user;
                    return true;
                }
                return false;
            }
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
}
