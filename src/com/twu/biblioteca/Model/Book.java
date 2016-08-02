package com.twu.biblioteca.Model;

public class Book {
    private String bookName;
    private String author;
    private int yearPublished;
    private boolean isCheckedOut;

    private User checkoutUser;

    public Book(String bookName,String author,int yearPublished,boolean isCheckedOut){
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isCheckedOut = isCheckedOut;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public User getCheckoutUser() {
        return checkoutUser;
    }

    public void setCheckoutUser(User checkoutUser) {
        this.checkoutUser = checkoutUser;
    }
}
