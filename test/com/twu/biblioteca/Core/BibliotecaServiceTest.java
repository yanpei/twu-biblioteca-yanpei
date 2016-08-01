package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import org.junit.Test;

import java.util.ArrayList;
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
        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(2,allBooksResult.size());
        assertEquals("book 1", allBooksResult.get(0).getBookName());
        assertEquals("book 2", allBooksResult.get(1).getBookName());

    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(2,allBooksResult.size());
        assertEquals("book 1", allBooksResult.get(0).getBookName());
        assertEquals("author 1", allBooksResult.get(0).getAuthor());
        assertEquals(2016, allBooksResult.get(0).getYearPublished());

        assertEquals("book 2", allBooksResult.get(1).getBookName());
        assertEquals("author 2", allBooksResult.get(1).getAuthor());
        assertEquals(2016, allBooksResult.get(1).getYearPublished());
    }

    @Test
    public void should_return_true_when_call_checkoutBook_if_the_book_has_not_been_checked_out_and_the_book_exists(){
        BibliotecaService bibliotecaService = new BibliotecaService();

        assertEquals(true, bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_has_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.getAllBooks().get(0).setIsCheckedOut(true);

        assertEquals(false,bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService();

        assertEquals(false,bibliotecaService.checkoutBook("book 3"));
    }

    @Test
    public void should_display_books_that_are_not_checked_out_when_calling_listBooks() {
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.checkoutBook("book 1");

        ArrayList<Book> books = bibliotecaService.listBooks();
        boolean isListed = true;
        for (Book book :
                books) {
            if (book.getBookName().equals("book 1")) {
                isListed = true;
                break;
            }else {
                isListed = false;
            }
        }

        assertEquals(true, bibliotecaService.getBookByName("book 1").getIsCheckedOut());
        assertEquals(false, isListed);
    }

    @Test
    public void should_return_true_when_call_returnBook_given_book_name_exist_and_been_checkedout(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.getAllBooks().get(0).setIsCheckedOut(true);

        assertEquals(true,bibliotecaService.returnBook("book 1"));
    }


    @Test
    public void should_return_false_when_call_returnBook_given_book_name_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService();

        assertEquals(false,bibliotecaService.returnBook("book 3"));
    }

    @Test
    public void should_return_false_when_call_returnBook_given_book_name_not_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService();

        assertEquals(false,bibliotecaService.returnBook("book 1"));
    }

    @Test
    public void should_display_books_that_are_returned_when_calling_listBooks(){
        BibliotecaService bibliotecaService = new BibliotecaService();

        bibliotecaService.returnBook("book 1");
        ArrayList<Book> books = bibliotecaService.listBooks();

        boolean isListed = true;
        for (Book book :
                books) {
            if (book.getBookName().equals("book 1")) {
                isListed = true;
                break;
            }else {
                isListed = false;
            }
        }

        assertEquals(false, bibliotecaService.getBookByName("book 1").getIsCheckedOut());
        assertEquals(true, isListed);
    }
}
