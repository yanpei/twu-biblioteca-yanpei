package com.twu.biblioteca.Shell;

import com.twu.biblioteca.Core.BibliotecaService;
import com.twu.biblioteca.Model.Book;
import com.twu.biblioteca.Resources.MainMenuText;
import com.twu.biblioteca.Router.BibliotecaRouter;
import com.twu.biblioteca.Router.RouterMessage;
import com.twu.biblioteca.Router.RouterState;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.Assert.assertEquals;

/**
 * Created by pyan on 7/31/16.
 */
public class BibliotecaShellTest {

    @Test
    public void should_display_welcome_message_when_current_state_is_Initializing() {
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.Initialization, new BibliotecaService());
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        String expectedResult = "Hello, welcome to the Biblioteca!";
        assertEquals(expectedResult, routerMessage.text);
    }

    @Test
    public void Should_display_main_menu_when_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService());
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage(null);

        String expectedResult = MainMenuText.mainMenuText;
        assertEquals(expectedResult,routerMessage.text);
    }

    @Test
    public void should_display_book_list_when_current_state_is_MainMenu_and_user_input_is_ListBooks(){
        BibliotecaService bibliotecaService = new BibliotecaService();
        bibliotecaService.allBooks.add(new Book("book 1","author 1",2016,false));
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, bibliotecaService);
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("1");


        String expectedResult = "BookName: book 1"
                              + "        Author: author 1"
                              + "        Published Year: 2016\n"
                              + "---------------------------\n";
        assertEquals(expectedResult,routerMessage.text);
        assertEquals(false,routerMessage.exit);
    }

    @Test
    public void should_display_invalid_message_when_user_input_is_not_list_Books_and_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService());
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("9");

        String expectedResult = "Select a valid option!\n" + MainMenuText.mainMenuText;
        assertEquals(expectedResult,routerMessage.text);
        assertEquals(false,routerMessage.exit);

    }

    @Test
    public void should_quit_when_user_input_is_Quit_and_current_state_is_MainMenu(){
        BibliotecaRouter bibliotecaRouter = new BibliotecaRouter(RouterState.MainMenu, new BibliotecaService());
        RouterMessage routerMessage = bibliotecaRouter.getRouterMessage("q");

        assertEquals(null,routerMessage.text);
        assertEquals(true,routerMessage.exit);
    }



}
