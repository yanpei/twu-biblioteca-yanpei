package com.twu.biblioteca.Resources;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
import java.util.ArrayList;
import java.util.List;

public class Repository {

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

    private ArrayList<User> users = new ArrayList<User>(){
        {
            add(new User("000-0001","12345","user 1","user1@163.com","123234"));
            add(new User("000-0005","12345","user 2","user2@163.com","123409"));
        }
    };

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
