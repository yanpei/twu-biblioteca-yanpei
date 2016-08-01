package com.twu.biblioteca.Model;

/**
 * Created by pyan on 8/1/16.
 */
public class Book {
    private String bookName;
    private String author;
    private int yearPublished;
    private boolean isCheckedOut;

    public Book(String bookName,String author,int yearPublished,boolean isCheckedOut){
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isCheckedOut = isCheckedOut;
    }

    @Override
    public String toString() {
        return "BookName: "+ getBookName() +"\t\tAuthor: "+ getAuthor() +"\t\tPublished Year: "+ getYearPublished();
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
}
