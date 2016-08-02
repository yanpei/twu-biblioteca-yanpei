package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
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
    private List<Movie> allMovies = new ArrayList<Movie>(){
        {
            add(new Movie("movie 1",2016,"director 1",2));
            add(new Movie("movie 2",2016,"director 2",0));
        }
    };

    public ArrayList<User> getUsers() {
        return users;
    }

    private ArrayList<User> users = new ArrayList<User>(){
        {
            add(new User("000-0001","12345",false));
        }
    };

    public User getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    private User loginUser;

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
            book.setCheckoutUser(loginUser);
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
}
