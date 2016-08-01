package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        String welcomeResult = new BibliotecaApp().getWelcomeMessage();
        assertEquals("Hello, welcome to the Biblioteca!",welcomeResult);
    }

    @Test
    public void should_list_all_books_names_when_calling_listBooks_method(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.allBooks.add(new Book("book 1","author 1",2016));

        List<Book> allBooksResult = bibliotecaApp.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        bibliotecaApp.allBooks.add(new Book("book 1","author 1",2016));

        List<Book> allBooksResult = bibliotecaApp.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
        assertEquals("author 1",allBooksResult.get(0).author);
        assertEquals(2016,allBooksResult.get(0).yearPublished);
    }
}
