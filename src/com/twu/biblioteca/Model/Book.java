package com.twu.biblioteca.Model;

/**
 * Created by pyan on 8/1/16.
 */
public class Book {
    public String bookName;
    public String author;
    public int yearPublished;
    public boolean isCheckedOut;

    public Book(String bookName,String author,int yearPublished){
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        isCheckedOut = false;
    }

    @Override
    public String toString() {
        return "BookName: "+bookName+"        Author: "+author+"        Published Year: "+yearPublished;
    }
}
