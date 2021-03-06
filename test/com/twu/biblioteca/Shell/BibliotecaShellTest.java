package com.twu.biblioteca.Shell;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Model.CheckOutItem;
import com.twu.biblioteca.Model.User;
import com.twu.biblioteca.Resources.MainMenuText;
import com.twu.biblioteca.Resources.Repository;
import com.twu.biblioteca.Router.BibliotecaRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaShellTest {

    @Test
    public void should_display_welcome_message_when_current_state_is_Initializing() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialization, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        String expectedResult = "Hello, welcome to the Biblioteca!";
        assertEquals(expectedResult, routerMessage.getText());
    }

    @Test
    public void Should_display_main_menu_when_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        String expectedResult = MainMenuText.getMainMenuText();
        assertEquals(expectedResult, routerMessage.getText());
    }

    @Test
    public void should_display_book_list_when_current_state_is_MainMenu_and_user_input_is_ListBooks(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("1");

        String expectedResult = "----------Book List--------\n"
                              + "BookName: book 1\t\tAuthor: author 1\t\tPublished Year: 2016\n"
                              + "BookName: book 2\t\tAuthor: author 2\t\tPublished Year: 2016\n"
                              + "---------------------------\n";
        assertEquals(expectedResult, routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_main_menu_when_current_state_is_MainMenu_and_user_input_is_ListBooks_and_continue_execution(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);

        bibliotecaRouter.getRouterMessage("1");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(), routerMessage.getText());
    }

    @Test
    public void should_display_invalid_message_when_user_input_is_not_list_Books_and_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("9");

        String expectedResult = "Select a valid option!\n";
        assertEquals(expectedResult, routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_main_menu_when_user_input_invalid_option_and_current_state_is_MainMenu_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));

        bibliotecaRouter.getRouterMessage("1");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(), routerMessage.getText());
    }

    @Test
    public void should_quit_when_user_input_is_Quit_and_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("q");

        assertEquals(null, routerMessage.getText());
        assertEquals(true, routerMessage.getExit());
    }

    @Test
    public void should_waiting_for_user_input_when_user_select_Checkout_books_and_current_status_is_MainMenu(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);

        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("2");

        assertEquals("Please input book name to checkout:\n", routerMessage.getText());
        assertEquals(true, routerMessage.isWaitingInput());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_main_menu_when_user_input_book_name_and_current_state_is_checkout_book_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Checkout, new BibliotecaService(new Repository()));

        bibliotecaRouter.getRouterMessage("book 1");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(), routerMessage.getText());
    }

    @Test
    public void should_display_not_checked_out_books_when_current_state_is_MainMenu_and_user_input_is_ListBooks(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Checkout, new BibliotecaService(new Repository()));
        bibliotecaRouter.getRouterMessage("book 2");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("1");

        String expectedResult =  "----------Book List--------\n"
                + "BookName: book 1\t\tAuthor: author 1\t\tPublished Year: 2016\n"
                + "---------------------------\n";
        assertEquals(expectedResult, routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_successful_message_when_current_state_is_Checkout_and_user_input_book_name_valid(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Checkout, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("book 1");

        assertEquals("Thank you! Enjoy the book\n\n", routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_unsuccessful_message_when_current_state_is_Checkout_and_user_input_book_name_not_exist_or_been_checked_out(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.getAllBooks().get(0).setIsCheckedOut(true);

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Checkout, bibliotecaService);
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("book 1");

        assertEquals("That book is not available.\n\n", routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_waiting_for_user_input_when_user_select_ReturnBook_and_current_state_is_MainMenu(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));

        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("3");

        assertEquals("Pleae input book name to return:\n", routerMessage.getText());
        assertEquals(true, routerMessage.isWaitingInput());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_main_menu_when_user_input_book_name_and_current_state_is_return_book_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, new BibliotecaService(new Repository()));

        bibliotecaRouter.getRouterMessage("book 1");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(), routerMessage.getText());
    }

    @Test
    public void should_display_returned_books_when_current_state_is_MainMenu_and_user_input_is_ListBooks(){
        Repository repository = new Repository();
        BibliotecaService bibliotecaService = new BibliotecaService(repository);
        Book book = bibliotecaService.getBookByName("book 1");
        book.setIsCheckedOut(true);
        User user = bibliotecaService.getUsers().get(0);
        repository.getCheckOutItems().add(new CheckOutItem(book,user));
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, bibliotecaService);
        bibliotecaRouter.getRouterMessage("book 1");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("1");

        String expectedResult = "----------Book List--------\n"
                + "BookName: book 1\t\tAuthor: author 1\t\tPublished Year: 2016\n"
                + "BookName: book 2\t\tAuthor: author 2\t\tPublished Year: 2016\n"
                + "---------------------------\n";
        assertEquals(expectedResult, routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_successful_message_when_current_state_is_return_book_and_user_input_book_name_exists_and_been_checked_out(){
        Repository repository = new Repository();
        BibliotecaService bibliotecaService = new BibliotecaService(repository);
        Book book = bibliotecaService.getBookByName("book 1");
        book.setIsCheckedOut(true);
        User user = bibliotecaService.getUsers().get(0);
        repository.getCheckOutItems().add(new CheckOutItem(book,user));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, bibliotecaService);
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));

        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("book 1");

        assertEquals("Thank you for returning the book.\n\n", routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_unsuccessful_message_when_current_state_is_return_book_and_user_input_book_name_not_exists_or_not_checked_out(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.ReturnBook, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("book 2");

        assertEquals("That is not a valid book to return.\n\n", routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_movie_list_with_name_year_director_and_movie_rating_when_current_state_is_MainMenu_and_userInput_is_ListMovies(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("4");

        String expectedResult = "----------Movie List--------\n"
                + "Name: movie 1\t\tYear: 2016\t\tDirector: director 1\t\tMovieRanting: 2\n"
                + "Name: movie 2\t\tYear: 2016\t\tDirector: director 2\t\tMovieRanting: unrated\n"
                + "---------------------------\n";
        assertEquals(expectedResult, routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_display_MainMenu_when_current_state_is_MainMenu_and_user_select_ListMovies_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));

        bibliotecaRouter.getRouterMessage("4");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(), routerMessage.getText());
        assertEquals(false, routerMessage.getExit());
    }

    @Test
    public void should_waiting_for_user_input_when_current_state_is_MainMenu_and_select_CheckoutMovie(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));

        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("5");

        assertEquals(true,routerMessage.isWaitingInput());
        assertEquals(false,routerMessage.getExit());
    }

    @Test
    public void should_display_MainMenu_when_current_state_is_CheckoutMovie_and_user_input_movie_name_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.CheckoutMovie, new BibliotecaService(new Repository()));
        bibliotecaRouter.getRouterMessage("5");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(),routerMessage.getText());
        assertEquals(false,routerMessage.getExit());
    }

    @Test
    public void should_waiting_for_user_input_when_current_state_is_MainMenu_and_select_login(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("6");

        assertEquals("Please login - split library number and password with " + "\",\"\n", routerMessage.getText());
        assertEquals(true,routerMessage.isWaitingInput());
        assertEquals(false,routerMessage.getExit());
    }

    @Test
    public void should_display_MainMenu_when_current_state_is_Login_and_user_input_username_and_password_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Login, new BibliotecaService(new Repository()));
        bibliotecaRouter.getRouterMessage("000-0001,12345");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(true,routerMessage.isWaitingInput());
        assertEquals(false,routerMessage.getExit());
    }

    @Test
    public void should_display_login_message_when_current_state_is_MainMenu_and_user_select_checkoutBook_and_user_not_login(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("2");

        assertEquals("Please login - split library number and password with " + "\",\"\n",routerMessage.getText());
    }

    @Test
    public void should_display_login_message_when_current_state_is_MainMenu_and_select_returnBook_and_user_not_login(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("3");

        assertEquals("Please login - split library number and password with " + "\",\"\n",routerMessage.getText());
    }

    @Test
    public void should_display_login_message_when_current_state_is_CheckoutMovie_and_user_not_login(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService(new Repository()));
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("5");

        assertEquals("Please login - split library number and password with " + "\",\"\n",routerMessage.getText());
    }

    @Test
    public void should_display_main_menu_with_informotion_option_when_current_state_is_Login_and_user_input_valid_library_number_and_password_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Login, new BibliotecaService(new Repository()));
        bibliotecaRouter.getRouterMessage("000-0001,12345");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuTextAfterLogin(),routerMessage.getText());
    }


    @Test
    public void should_display_main_menu_without_information_option_when_current_state_is_Login_and_user_input_invalid_library_number_or_password_and_continue_execution(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Login, new BibliotecaService(new Repository()));
        bibliotecaRouter.getRouterMessage("000-0001,12324");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuText(),routerMessage.getText());
    }

    @Test
    public void should_display_information_when_current_state_is_MainMenu_and_select_information_option_and_user_has_login(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        User user = bibliotecaService.getUsers().get(0);
        bibliotecaService.setLoginUser(user);
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);

        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("7");

        String expectedResult = "----------My Information--------\n"
                +"Name: "+ user.getName()
                + "\t\tEmail Address: " + user.getEmaiAddress()
                + "\t\tPhone Number: " + user.getPhoneNumber() + "\n"
                + "---------------------------\n";
        assertEquals(expectedResult,routerMessage.getText());
    }

    @Test
    public void should_display_MainMenu_with_information_option_when_current_state_is_MainMenu_and_select_information_and_continue_execution(){
        BibliotecaService bibliotecaService = new BibliotecaService(new Repository());
        bibliotecaService.setLoginUser(bibliotecaService.getUsers().get(0));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);

        bibliotecaRouter.getRouterMessage("7");
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        assertEquals(MainMenuText.getMainMenuTextAfterLogin(), routerMessage.getText());
    }

}
