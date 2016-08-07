package com.twu.biblioteca.Core;

import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.Movie;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Resources.Repository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BibliotecaServiceTest {
    @Test
    public void should_get_welcome_message_when_calling_getWelcomeMessage_method(){
        String welcomeResult = new BibliotecaService(new Repository()).getWelcomeMessage();
        assertEquals("Hello, welcome to the Biblioteca!",welcomeResult);
    }

    @Test
    public void should_list_all_books_names_when_calling_listBooks_method(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        List<Book> allBooksResult = bibliotecaService.listBooks();

        assertEquals(2,allBooksResult.size());
        assertEquals("book 1", allBooksResult.get(0).getBookName());
        assertEquals("book 2", allBooksResult.get(1).getBookName());

    }

    @Test
    public void Should_list_all_books_with_name_author_published_year(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
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
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        assertEquals(true, bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_has_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.getAllBooks().get(0).setIsCheckedOut(true);

        assertEquals(false,bibliotecaService.checkoutBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_checkoutBook_if_the_book_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        assertEquals(false,bibliotecaService.checkoutBook("book 3"));
    }

    @Test
    public void should_display_books_that_are_not_checked_out_when_calling_listBooks() {
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
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
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.getAllBooks().get(0).setIsCheckedOut(true);

        assertEquals(true,bibliotecaService.returnBook("book 1"));
    }

    @Test
    public void should_return_false_when_call_returnBook_given_book_name_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        assertEquals(false,bibliotecaService.returnBook("book 3"));
    }

    @Test
    public void should_return_false_when_call_returnBook_given_book_name_not_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        assertEquals(false,bibliotecaService.returnBook("book 1"));
    }

    @Test
    public void should_display_books_that_are_returned_when_calling_listBooks(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

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

    @Test
    public void  should_get_movie_list_contain_available_movies_when_calling_listMovies(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        List<Movie> allMovieResult = bibliotecaService.listMovies();

        assertEquals(2, allMovieResult.size());
        assertEquals("movie 1", allMovieResult.get(0).getName());
        assertEquals(2016, allMovieResult.get( 0).getYear());
        assertEquals("director 1", allMovieResult.get(0).getDirector());
        assertEquals(2, allMovieResult.get(0).getMovieRanting());
    }

    @Test
    public void should_return_true_when_calling_checkoutMovie_given_checkout_movie_name_exists(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        boolean isCheckedSuccessful = bibliotecaService.checkoutMovie("movie 1");

        assertEquals(true,isCheckedSuccessful);
    }

    @Test
    public void should_return_false_when_calling_checkoutMovie_given_checkout_movie_name_not_exist(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        boolean isCheckedSuccessful = bibliotecaService.checkoutMovie("movie 3");

        assertEquals(false,isCheckedSuccessful);
    }

    @Test
    public void should_return_true_and_when_calling_login_given_username_exists_password_true() {
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        boolean isLoginSuccessful = bibliotecaService.login("000-0001,12345");

        assertEquals(true, isLoginSuccessful);
        assertNotNull(bibliotecaService.getLoginUser());
        assertEquals(true,bibliotecaService.getLoginUser().isLogin());
    }

    @Test
    public void should_return_false_and_when_calling_login_given_username_exists_and_password_not_true() {
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        boolean isLoginSuccessful = bibliotecaService.login("000-0001,23333");

        assertEquals(false, isLoginSuccessful);
        assertNull(bibliotecaService.getLoginUser());
    }

    @Test
    public void should_return_false_and_when_calling_login_given_username_not_exists() {
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());

        boolean isLoginSuccessful = bibliotecaService.login("000-0002,12345");

        assertEquals(false, isLoginSuccessful);
        assertNull(bibliotecaService.getLoginUser());
    }

    @Test
    public void should_return_true_and_update_checked_book_isChecked_and_checkoutUser_when_calling_checkoutBook_given_valid_book_and_user_has_login(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));

        boolean isCheckoutBookSuccessful = bibliotecaService.checkoutBook("book 1");
        User checkoutUser = bibliotecaService.getBookByName("book 1").getCheckoutUser();

        assertEquals(true, isCheckoutBookSuccessful);
        assertEquals(bibliotecaService.getUsers().get(0),checkoutUser);
    }

    @Test
    public void should_return_true_and_update_checked_book_isChecked_and_checkoutUser_when_calling_returnBook_given_valid_book_and_loginUser_equal_with_checkOutUser_of_book(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.getBookByName("book 1").setIsCheckedOut(true);
        bibliotecaService.getBookByName("book 1").setCheckoutUser(bibliotecaService.getUsers().get(0));
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));

        boolean isCheckoutBookSuccessful = bibliotecaService.returnBook("book 1");

        User checkoutUser = bibliotecaService.getBookByName("book 1").getCheckoutUser();
        boolean isCheckedout = bibliotecaService.getBookByName("book 1").getIsCheckedOut();
        assertEquals(true, isCheckoutBookSuccessful);
        assertEquals(null, checkoutUser);
        assertEquals(false, isCheckedout);
    }

    @Test
    public void should_return_false_when_calling_checkoutBook_given_valid_book_but_loginUser_not_equal_with_checkOutUser_of_book(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.getBookByName("book 1").setIsCheckedOut(true);
        bibliotecaService.getBookByName("book 1").setCheckoutUser(bibliotecaService.getUsers().get(0));
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(1));

        boolean isCheckoutBookSuccessful = bibliotecaService.returnBook("book 1");

        User checkoutUser = bibliotecaService.getBookByName("book 1").getCheckoutUser();
        boolean isCheckedout = bibliotecaService.getBookByName("book 1").getIsCheckedOut();
        assertEquals(false, isCheckoutBookSuccessful);
        assertEquals(bibliotecaService.getUsers().get(0), checkoutUser);
        assertEquals(true, isCheckedout);
    }

}
