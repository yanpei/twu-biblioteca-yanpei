package com.twu.biblioteca.Model;

/**
 * Created by pyan on 8/9/16.
 */
public class CheckOutItem {
    private Book checkOutBook;
    private User user;

    public CheckOutItem(Book checkOutBook, User user) {
        this.checkOutBook = checkOutBook;
        this.user = user;
    }

    public Book getCheckOutBook() {
        return checkOutBook;
    }

    public User getUser() {
        return user;
    }
}
