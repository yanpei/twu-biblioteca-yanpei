package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaServiceTest {
    @Test
    public void should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        String welcomeResult = new BibliotecaService().getWelcomeMessage();
        assertEquals("Hello, welcome to the Biblioteca!",welcomeResult);
    }

    @Test
    public void should_list_all_books_names_when_calling_listBooks_method(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016));

        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016));

        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
        assertEquals("author 1",allBooksResult.get(0).author);
        assertEquals(2016,allBooksResult.get(0).yearPublished);
    }


}