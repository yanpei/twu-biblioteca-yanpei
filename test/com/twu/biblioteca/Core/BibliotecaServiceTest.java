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
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,false));

        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,false));

        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(1,allBooksResult.size());
        assertEquals("book 1",allBooksResult.get(0).bookName);
        assertEquals("author 1",allBooksResult.get(0).author);
        assertEquals(2016,allBooksResult.get(0).yearPublished);
    }

    @Test
    public void should_return_true_when_call_checkoutBook_if_the_book_has_not_been_checked_out_and_the_book_exists(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,false));
        bibliotecaService.allBooks.add(new Book("book 2","author 2",2016,false));

        assertEquals(true,bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_has_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,true));
        bibliotecaService.allBooks.add(new Book("book 2","author 2",2016,false));

        assertEquals(false,bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,true));
        bibliotecaService.allBooks.add(new Book("book 2","author 2",2016,false));

        assertEquals(false,bibliotecaService.checkoutBook("book 3"));
    }



}
